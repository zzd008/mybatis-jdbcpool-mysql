package com.briup.bean;

import java.util.Set;

public class Course {
	private int id;
	private String course_code;
	private String course_name;
	private Set<Stu> stus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Set<Stu> getStus() {
		return stus;
	}
	public void setStus(Set<Stu> stus) {
		this.stus = stus;
	}
	public Course(String course_code, String course_name) {
		super();
		this.course_code = course_code;
		this.course_name = course_name;
	}
	public Course() {
		
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course_code=" + course_code
				+ ", course_name=" + course_name + ", stus=" + stus + "]";
	}
	
}
