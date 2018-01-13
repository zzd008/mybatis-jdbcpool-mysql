package com.briup.bean;

import java.util.Set;

/*
 * 学生-课程
 */
public class Stu {
	private int id;
	private String name;
	private String gender;
	private String major;
	private String grader;//数据库中列名写成了frader
	private Set<Course> courses;//用于关系维护
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrader() {
		return grader;
	}
	public void setGrader(String grader) {
		this.grader = grader;
	}
	public Stu(String name, String gender, String major, String grader) {//不用主键，主键由数据库自增长
		super();
		this.name = name;
		this.gender = gender;
		this.major = major;
		this.grader = grader;
	}
	public Stu() {
		
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", major=" + major + ", grader=" + grader + ", courses="
				+ courses + "]";
	}
	
}
