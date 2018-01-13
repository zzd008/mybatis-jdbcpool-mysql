package com.briup.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;
import com.mysql.jdbc.Driver;

public class BaseOpt {
	@Test
	public void create_driver4(){
		String url="jdbc:mysql://localhost:3306/briup";
		Properties info=new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "");
		try {
			Connection conn=
					new Driver().connect(url, info);
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void create_driver3(){
		String url="jdbc:mysql://localhost:3306/briup"
				+"?user=root&password=";
		Connection conn=null;
		//第四种注册驱动，给虚拟机传参数
		//-Djdbc.drivers=com.mysql.jdbc.Driver
		try {
			conn=DriverManager.getConnection(url);
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void create_driver2(){
		//获取系统配置参数
//		Properties pro=System.getProperties();
//		for(Object key:pro.keySet()){
//			System.out.println(key+
//					"---"+pro.getProperty((String)key));
//		}
		String url="jdbc:mysql://localhost:3306/briup";
		Properties info=new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "");
		Connection conn=null;
		try {
			//第三中注册驱动方式,给虚拟机设置
			//参数
			System.setProperty("jdbc.drivers", 
					"com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, info);
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void create_driver1(){
		String url="jdbc:mysql://localhost:3306/briup"
+"?user=root&password=&characterEncoding=UTF8";
		Connection conn=null;
		try {
			Driver driver=new Driver();
			//第二种方式注册驱动
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url);
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void create_driver(){
		//链接数据库的四要素
		//驱动程序
		String driver="com.mysql.jdbc.Driver";
		//请求资源定位
		//jdbc:子协议://ip:port/数据库?key=value&key=value
		//String url="jdbc:mysql://127.0.0.1:3306/briup";
		String url="jdbc:mysql://192.168.2.41:3306/briup";
		//数据库的用户名
		String user="root";
		//数据库的密码
		String password="root";
		Connection conn=null;
		try {
			//注册驱动
			Class.forName(driver);
			//获取链接
			conn=DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
