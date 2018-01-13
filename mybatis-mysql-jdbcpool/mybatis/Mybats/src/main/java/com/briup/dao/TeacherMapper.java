package com.briup.dao;

import java.util.List;

import com.briup.bean.Teacher;

public interface TeacherMapper {
	void insertTeacher(Teacher tea);
	List<Teacher> selectAllTeacher();
}
