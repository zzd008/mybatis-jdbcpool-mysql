package com.briup.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.briup.bean.Customer;

public interface CustomerMapper {
	//注解 不使用映射文件
	@Insert(value="insert into s_cus values(#{id},#{username},#{age})")
//	@Insert(value="insert into s_cus values(null,#{username},#{age})") id自增长
	void insertCustomer(Customer c);
	
	@Insert(value="insert into s_cus values(#{username},#{age})")
	@Options(useGeneratedKeys=true,keyProperty="id")//获取主键的值 赋给对象的id属性
	void autoInsertCustomer(Customer c);
	
	@Update(value="update s_cus set name='周致达' where id=#{id}")
	void updatCustomer(Customer c);
	
	@Select(value="select id,name as username,age from s_cus where id=#{id}")
	Customer findCustomerById(int id);
	
	//数据库中列名和类中属性不一致时
	@Select(value="select* from s_cus where id=#{id}")
	@Results(
			value={
					@Result(id=true,property="id",column="id"),//一一对应，id=true标识id为主键
					@Result(property="username",column="name"),
//					@Result(property="age",column="age")
				}
			)
	Customer findCustomerModelById(int id);
	
	@Select(value="select id,name as username,age from s_cus")
	List<Customer> findAllCustomer();
	
	void  saveCustomer_auto(Customer cus);
	
	Customer findOneCustomerById(int id);
	
	List<Customer> findAllCustomers_list();
	
	Set<Customer> findAllCustomers_set();
	
	/*
	 * 返回SortedSet，范型中的对象要实现Comparable
	 * 定义排序的规则，具体实现treeSet
	 */
	SortedSet<Customer> findAllCustomers_sortedtset();
	
	/*
	 * 数据库查询的结果集每一行封装成一个map结合
	 * key是数据库的列名，值是列对应的值
	 */
	Map<String,Object> findAllCustomers_map(int id);
	
	/*
	 * 返回多行数据，一行数据对应一个map
	 * 多个map可以用list或set接受
	 */
	List<Map<String,Object>> findAllCustomers_map_list();
	
	/*
	 * 多个参数传值给sql语句
	 */
	Customer findCustomerByIdNameAge(int id,String username,int age);
	
	
	Map<Integer,Customer> findCustomerByName();//id为key，列中的一行村委Customer对象作为value
}
