package com.briup.DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.briup.Bean.Teacher;
import com.briup.Util.Model.JDBC_util;

/*
 * apache工具类的使用
 */
public class DB_dbutils {
	@Test
	public void dbutils_insert(){
		//构建工具
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="insert into tea values(16,'briup_test')";
		try {
			Object obj=run.insert(conn, sql, new ResultSetHandler<Object>() {
				@Override
				public Object handle(ResultSet arg0) throws SQLException {
					// TODO Auto-generated method stub
					return "hello";
				}
			});
			System.out.println(obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_update(){
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="update tea set name=? where id=?";
		try {
			int n=run.update(conn, sql, "helloworld",15);
			System.out.println(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_select(){
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea where 1=?";
		try {
			List<Teacher> teas=run.query(conn, sql,
					new ResultSetHandler<List<Teacher>>(){
				@Override
				public List<Teacher> handle(ResultSet arg0) throws SQLException {
					// TODO Auto-generated method stub
					List<Teacher> list=new ArrayList<>();
					while(arg0.next()){
						int id=arg0.getInt(1);
						String name=arg0.getString(2);
						Teacher tea=new Teacher();
						tea.setId(id);
						tea.setName(name);
						list.add(tea);
					}
					return list;
				}
			}, 1);
			System.out.println(teas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_selectBean(){
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea where id=15";
		Teacher tea=null;
		try {
			//注意工具结果集处理的时候是调用反射在调用
			//反射创建的对象中set方法，必须保证Teacher类
			//的set方法去掉set首字母小写和数据库中字段一致
			tea=
			run.query(conn, sql, new BeanHandler<Teacher>(Teacher.class));
			System.out.println(tea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_selectListBean(){
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea";
		List<Teacher> tea=null;
		try {
			tea=
					run.query(conn, sql, new BeanListHandler<Teacher>(Teacher.class));
			System.out.println(tea);
			System.out.println(tea.getClass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_selectMapBean(){
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea";
		Map<String,Object> tea=null;
		try {
			//没有指定key的情况下第一列作为key
		tea=run.query(conn, sql, new BeanMapHandler(Teacher.class));
			System.out.println(tea);
			System.out.println(tea.getClass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_selectMapBean1(){
		QueryRunner run=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea";
		Map<String,Teacher> tea=null;
		try {
			//没有指定key的情况下第一列作为key
			//第二个参数可以指定具体那列作为key
			//第二个参数可以写列的角标也可以写列的名字
			//tea=run.query(conn, sql, new BeanMapHandler<>(Teacher.class, 2));
			tea=
		run.query(conn, sql, new BeanMapHandler<String,Teacher>(Teacher.class, "name"));
			System.out.println(tea);
			System.out.println(tea.getClass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_mapH(){
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql ="select * from tea";
		Map<String, Object> map=null;
		try {
			//返回一个结果，列名作为key，值是数据库内容行的值
			//注意：MapHandler只返回第一行
			map=qr.query(conn, sql, new MapHandler());
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_mapH1(){
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql ="select * from tea";
		List<Map<String, Object>> map=null;
		try {
			//返回一个结果，列名作为key，值是数据库内容行的值
			//注意：MapHandler只返回第一行
			map=qr.query(conn, sql, new MapListHandler());
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 返回结果集中的第一行第一列
	 */
	@Test
	public void dbutils_scalar(){
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBC_util.getConn();
		String sql ="select * from tea";
		try {
			//返回一个结果，列名作为key，值是数据库内容行的值
			//注意：MapHandler只返回第一行
			int map=qr.query(conn, sql, new ScalarHandler<Integer>());
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dbutils_loader(){
		QueryLoader load=QueryLoader.instance();
		try {
			Map<String, String> map=load.load("/sql.properties");
			System.out.println(map);
			System.out.println(map.get("mysql"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}







