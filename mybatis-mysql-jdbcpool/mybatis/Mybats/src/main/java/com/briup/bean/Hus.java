package com.briup.bean;

public class Hus {
	private int id;
	private String name;
	private int age;
	private Wife wife;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	@Override
	public String toString() {
		return "Hus [id=" + id + ", name=" + name + ", age=" + age + ", wife="
				+ wife.getId()+" "+wife.getName() + "]";
	}
	public Hus(int id, String name, int age, Wife wife) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.wife = wife;
	}
	public Hus() {
		
	}
}
