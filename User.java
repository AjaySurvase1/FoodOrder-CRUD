package org.jsp.assignmentApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name ;
	private String gender;
	private String email;
@Column(unique = true)
	private long phone;
@Column(unique = true)
	private String password;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "u")
	private List<FoodOrder> food_order;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<FoodOrder> getFood_order() {
	return food_order;
}
public void setFood_order(List<FoodOrder> food_order) {
	this.food_order = food_order;
}


}
