package com.briup.dao;

import java.util.List;
import java.util.Map;

import com.briup.bean.Student;

public interface StudentMapper {
	void saveStudent(Student student);
	void deleteStudent(int id);
	void updateStudent(Student stu);
	Student findStudentById(int id);
	List<Student> findAllStudent();
	List<Map<Object,Object>> findAllStudent1();//key:列名 value：值
	Map<Object,Object> findAllStudent2();
}
