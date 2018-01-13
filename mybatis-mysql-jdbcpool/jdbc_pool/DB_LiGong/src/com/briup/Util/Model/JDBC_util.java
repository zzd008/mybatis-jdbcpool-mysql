package com.briup.Util.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC_util {
	/*
	 * ThreadLocal 线程安全的本地变量，一般可以直接和线程绑定
	 * 线程和线程之间操作的ThreadLocal都是独有的，
	 * 该变量只能存储一个对象
	 */
	private static ThreadLocal<Connection> th=new ThreadLocal<>();
	public static Connection getConn(){
		Connection conn=th.get();
		try {
			if(conn==null){
				Properties pro=new Properties();
				pro.load(new FileReader(new File("src/com/briup/Util/Model/conn.txt")));
				Class.forName(pro.getProperty("driver"));
				conn=DriverManager.getConnection(pro.getProperty("url"), 
						pro.getProperty("user"), pro.getProperty("password"));
				th.set(conn);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(JDBC_util.getConn());
	}
}
