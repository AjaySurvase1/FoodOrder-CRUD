 package org.jsp.assignmentApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.assignmentApp.dto.FoodOrder;
import org.jsp.assignmentApp.dto.User;

public class FoodOrderOperation {

	public FoodOrder saveFd(FoodOrder fd,int user_id) {
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		User u=manager.find(User.class, user_id);
		if(u!=null) {
			u.getFood_order().add(fd);
			fd.setU(u);
			manager.persist(fd);
			t.begin();
			t.commit();
			return fd;
		}
		return null;
	}
	
	public FoodOrder updateFd(FoodOrder fd,int user_id) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		User u=manager.find(User.class, user_id);
		if(u!=null) {
			u.getFood_order().add(fd);
			manager.merge(fd);
			t.begin();
			t.commit();
			return fd;
		}
		return null;
	}
	
	
	public List<FoodOrder> fetchfdByUId(int id) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery("select u.food_order from User u where u.id=?1");
		q.setParameter(1, id);
		return q.getResultList();

	}
	
	public List<FoodOrder> fetchfdByemailandPassword(String email,String password){
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery("select u.food_order from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return q.getResultList();
	}
	
	public boolean deleteFoodOrder(String email,String password) {
		EntityManager manager =Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		Query q=manager.createQuery("select u.food_order from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<FoodOrder> list_fd=q.getResultList();
		
		if(list_fd!=null) {
			manager.remove(list_fd);
			t.begin();
			t.commit();
			return true;
		}
		return false;
		
	}
}
