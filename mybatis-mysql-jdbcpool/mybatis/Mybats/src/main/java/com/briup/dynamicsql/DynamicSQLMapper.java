package com.briup.dynamicsql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.briup.bean.Stu;

/*动态sql语句，用于条件不确定的查询
 * where语句的生产依赖于传入的查询名字
 */
public interface DynamicSQLMapper {
	List<Stu> findStudent(Map<String,Object> map);
	List<Stu> findStudent_choose(Map<String,Object> map);
	List<Stu> findStudent_where(Map<String,Object> map);
	List<Stu> findStudent_trim(Map<String,Object> map);
	List<Stu> findStudent_foreach(Map<String,Object> map);
	List<Stu> findStudent_foreach1(Map<String,Object> map);
	void updateStu(@Param("id") int id,@Param("name") String name);//传递多个参数
}
