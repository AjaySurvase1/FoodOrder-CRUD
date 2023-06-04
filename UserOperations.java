package org.jsp.assignmentApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.assignmentApp.dto.FoodOrder;
import org.jsp.assignmentApp.dto.User;

public class UserOperations {

	
	
	public User saveUser(User u) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		manager.persist(u);
		t.begin();
		t.commit();
		return u;
	}
	
	public User verifyUser(String email, String password) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		Query q=manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<User> list=q.getResultList();
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	public User updateUser(User u) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		manager.merge(u);
		t.begin();
		t.commit();
		return u;
	}
	public User findUById(int id) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		return manager.find(User.class, id);
	}
	
	
	
}
