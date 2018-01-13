package com.briup.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

//在类中配置别名，需要配置文件中指定扫描的包
//@Alias(value="stu") 这两种方式等价的
//@Alias("stu")
public class Student {
	private int id;
	private String name;
	private int age;
	private Date dob;//mybatis会将时间自动转化为java.sql.date
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", dob=" + dob + "]";
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Student(int id, String name, int age, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
	}
	public Student() {
		System.out.println("构建无参对象！");
	}
	
	
}
