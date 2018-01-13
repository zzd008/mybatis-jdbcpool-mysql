package com.briup.bean;

public class Wife {
	private int id;
	private String name;
	private int age;
	private Hus hus;
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
	public Hus getHus() {
		return hus;
	}
	public void setHus(Hus hus) {
		this.hus = hus;
	}
	@Override
	public String toString() {
		return "Wife [id=" + id + ", name=" + name + ", age=" + age +" "+hus.getName();
	}
	public Wife(int id, String name, int age, Hus hus) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hus = hus;
	}
	public Wife() {
		
	}
}
