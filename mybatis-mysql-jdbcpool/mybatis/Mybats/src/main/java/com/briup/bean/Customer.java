package com.briup.bean;

public class Customer implements Comparable<Customer>{
	private int id;
	private String username;//设置成与数据库的类名不一致 name
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Customer(int id, String username, int age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	public Customer() {
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", age=" + age
				+ "]";
	}
	public int compareTo(Customer o) {
		System.out.println(this.getId()+"----"+o.getId());
		return this.id-o.getId();
	}
}
