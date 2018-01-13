package com.briup.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class DB_PS {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/briup?user=root&password=";
	public static void main(String[] args) {
		new DB_PS().db_select(1, "wangwu");
	}
	public void db_select(int id,String name){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			String sql="select * from stu where id=? and name=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"---"+rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Test
	public void db_insert1(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			//?表示占位
			String sql="insert into stu values(11,?)";
			ps=conn.prepareStatement(sql);
			//设置值,第一个参数表示是第几个占位符？，
			//和设置在values中的位置没关系
			ps.setString(1, "testzhangsan");
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Test
	public void db_insert(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			//?表示占位
			String sql="insert into stu values(?,?)";
			ps=conn.prepareStatement(sql);
			//设置值,第一个参数表示是第几个占位符？，
			//和设置在values中的位置没关系
			ps.setInt(1, 10);
			ps.setString(2, "wangwuBriup");
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
