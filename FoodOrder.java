package org.jsp.assignmentApp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class FoodOrder {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
@UpdateTimestamp
	private LocalDate del_time;
@CreationTimestamp
	private LocalDate order_time;
	private double price;
	private String address;
	private String item_name;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_id")
	private User u;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDel_time() {
		return del_time;
	}
	public void setDel_time(LocalDate del_time) {
		this.del_time = del_time;
	}
	public LocalDate getOrder_time() {
		return order_time;
	}
	public void setOrder_time(LocalDate order_time) {
		this.order_time = order_time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getItem_name() {
		return item_name;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
}
