package com.briup.manytomany;

import com.briup.bean.*;

public interface ManyToManyMapper {
	void saveStu(Stu s);
	void saveCourse(Course c);
	//学生选择了某门课程(桥表)
	void selectCourse(Stu s,Course c);
	//通过学生id查询出学生信息及所选课程
	Stu findStuById(int id);
	//查询出选择了某门课程的所有学生
	Course findCourseById(int id);
}
