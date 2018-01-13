package com.briup.bean;

import java.util.Set;

public class User {
	private int userid;
	private String name;
	private String password;
	private Set<Order> orders;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password="
				+ password + ", orders=" + orders + "]";
	}
	
}
