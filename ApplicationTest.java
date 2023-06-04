package org.jsp.assignmentApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsp.assignmentApp.dao.FoodOrderOperation;
import org.jsp.assignmentApp.dao.UserOperations;
import org.jsp.assignmentApp.dto.FoodOrder;
import org.jsp.assignmentApp.dto.User;

public class ApplicationTest {
	static Scanner sc=new Scanner(System.in);
	static UserOperations op=new UserOperations();
	static FoodOrderOperation foodorder=new FoodOrderOperation();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean check=true;
		while(check) {
			System.out.println("1.save User");
			System.out.println("2.verify User");
			System.out.println("3.add foodOrder");
			System.out.println("4.update User");
			System.out.println("5.update foodOrder");
			System.out.println("6.fetch foodOrders by user Id");
			System.out.println("7.fetch foodOrders by user email and password");
			System.out.println("8.delete foodorder");
			
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				sUser();
				break;
			case 2:
				vUser();
				break;
			case 3:
				addFO();
				break;
			case 4:
				uUser();
				break;
			case 5:
				uFoodOrder();
				break;
			case 6:
				fetchfByUserId();
				break;
			case 7:
				fetchFoodByemailPassword();
				break;
			case 8:
				dFoodOrder();
				
			}
		}
		
	
		
	}
	public static void sUser() {
		System.out.println("enter name email gender phone and password");
		String name=sc.next();
//		name=sc.nextLine();
		String email=sc.next();
		String gender=sc.next();
		long phone =sc.nextLong();
		String password=sc.next();
		
		User u=new User();
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPhone(phone);
		u.setPassword(password);
		u=op.saveUser(u);
	}
	public static void vUser()
	{
		System.out.println("Enter email and password to verify...");
		String email=sc.next();
		String password=sc.next();
		User u=new User();
		u=op.verifyUser(email, password);
		if(u!=null) {
			System.out.println("id"+u.getId());
			System.out.println(""+u.getName());
			System.out.println(""+u.getGender());
			System.out.println(""+u.getPhone());
			System.out.println(""+u.getEmail());
		}
	}
	
	public static void addFO() {
		System.out.println("enter id to check whether the user present or not");
		int user_id=sc.nextInt();
		User u=op.findUById(user_id);
		if(u!=null) {
			System.out.println("enter item name price add");
			String item=sc.next();
			double price=sc.nextDouble();
			String add=sc.next();
			
			FoodOrder fd=new FoodOrder();
			fd.setItem_name(item);
			fd.setPrice(price);
			fd.setAddress(add);
			fd=foodorder.saveFd(fd, user_id);
			System.out.println("order placed for"+u.getName());
		}
		
	}

	public static void uUser() {
		int uid=sc.nextInt();
		User u=op.findUById(uid);
		if(u!=null) {
			System.out.println("enter id name email gender phone and password");
			int id=sc.nextInt();
			String name=sc.next();
//			name=sc.nextLine();
			String email=sc.next();
			String gender=sc.next();
			long phone =sc.nextLong();
			String password=sc.next();
			
			u.setId(id);
			u.setName(name);
			u.setEmail(email);
			u.setGender(gender);
			u.setPhone(phone);
			u.setPassword(password);
			u=op.updateUser(u);
		}
		
	}
	public static void uFoodOrder() {
		;
		System.out.println("Enter id price, add, item...");
		int id=sc.nextInt();
		double price=sc.nextDouble();
		String add=sc.next();
		String item=sc.next();
		
		FoodOrder f=new FoodOrder();
		f.setId(id);
		f.setPrice(price);
		f.setAddress(add);
		f.setItem_name(item);
		int uid=sc.nextInt() ;
		f=foodorder.updateFd(f, uid);
		
	}

	public static void dFoodOrder() {
		
		System.out.println("Enter email and password to delete food order..");
		String email=sc.next();
		String password=sc.next();
		boolean delete=foodorder.deleteFoodOrder(email, password);
		if(delete) {
			System.out.println("order deleted..");
		}
		else {
			System.out.println("invalid email or password!!!");
		}
	}
	public static void fetchfByUserId() {
		System.out.println("enter user id....");
		int id=sc.nextInt();
//		User u=op.findUById(id);
		for(FoodOrder fd:foodorder.fetchfdByUId(id)) {
			System.out.println(fd.getItem_name());
			System.out.println(fd.getPrice());
			System.out.println(fd.getAddress());
			System.out.println(fd.getDel_time());
			
		}
	}

	public static void fetchFoodByemailPassword() {
		System.out.println("Enter email and password");
		String email=sc.next();
		String password=sc.next();
		
		for(FoodOrder fd:foodorder.fetchfdByemailandPassword(email, password)) {
			System.out.println(fd.getItem_name());
			System.out.println(fd.getPrice());
			System.out.println(fd.getAddress());
			System.out.println(fd.getDel_time());
		}
	}
}
