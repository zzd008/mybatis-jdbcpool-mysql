package com.briup.bean;

public class Teacher {
	private int id;
	private String name;
	private Phone phone;
	public long getId() {
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
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", phone=" + phone
				+ "]";
	}
	public Teacher(int id, String name, Phone phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public Teacher() {
	}
}
