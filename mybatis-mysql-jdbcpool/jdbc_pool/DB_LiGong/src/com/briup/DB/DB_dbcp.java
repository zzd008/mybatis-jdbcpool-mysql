package com.briup.DB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

/*
 * apache提供的数据源
 */
public class DB_dbcp {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/briup";
	private String user="root";
	private String password="";
	@Test
	public void dbcp_test2(){
		Properties pro=new Properties();
		try {
			pro.load(new FileReader("src/dbcpconfig.properties"));
			BasicDataSource pool=
					BasicDataSourceFactory.createDataSource(pro);
			System.out.println(pool.getConnection());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void dbcp_test1(){
		try {
		BasicDataSource pool=new BasicDataSource();
		//设置连接参数
		pool.setUrl(url);
		pool.setDriverClassName(driver);
		pool.setUsername(user);
		pool.setPassword(password);
		//设置初始状态创建几个连接对象
		pool.setInitialSize(3);
		//设置最大连接数
		pool.setMaxTotal(5);
		//设置没有连接的时候等待时间
		pool.setMaxWaitMillis(5000);
		Connection conn=pool.getConnection();
		System.out.println(conn);
		Connection conn1=pool.getConnection();
		System.out.println(conn1);
		Connection conn2=pool.getConnection();
		System.out.println(conn2);
		Connection conn3=pool.getConnection();
		System.out.println(conn3);
		Connection conn4=pool.getConnection();
		System.out.println(conn4);
		//数据连接关闭是把连接对象放回数据连接池
		conn4.close();
		Connection conn5=pool.getConnection();
		System.out.println(conn5);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}








