package com.briup.bean;

public class Order {
	private int orderid;
	private String name;
	private double salary;
	private User user;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", name=" + name + ", salary="
				+ salary + ", user=" + user + "]";
	}
	
}
