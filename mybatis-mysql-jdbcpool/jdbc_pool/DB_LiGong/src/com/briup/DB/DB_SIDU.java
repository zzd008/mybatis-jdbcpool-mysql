package com.briup.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class DB_SIDU {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/briup";
	private String user="root";
	private String password="";
	public static void main(String[] args) {
		//new DB_SIDU().db_insert(8,"中test");
//		new DB_SIDU().db_update(10, "test");
		new DB_SIDU().db_delete(8);
	}
	@Test
	public void db_createDB(){
		Connection conn=null;
		Statement sts=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			sts=conn.createStatement();
			String sql="create table DB_SID(id int primary key auto_increment,"
					+ "name text,birth Date )";
			sts.execute(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void db_delete(int id){
		Connection conn=null;
		Statement sts=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			sts=conn.createStatement();
			String sql="delete from stu where id="+id;
//			boolean b=sts.execute(sql);
//			System.out.println(b);
			int n=sts.executeUpdate(sql);
			System.out.println(n);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void db_update(int id,String name){
		Connection conn=null;
		Statement sts=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			sts=conn.createStatement();
			//String sql="update stu set name='"+name+"' where id="+id;
			String sql="update stu set id="+id+" where name='"+name+"'";
//			boolean b=sts.execute(sql);
//			System.out.println(b);
			int n=sts.executeUpdate(sql);
			System.out.println(n);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Test
	public void db_update(){
		Connection conn=null;
		Statement sts=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			sts=conn.createStatement();
			String sql="update stu set name='briup' where id=8";
			boolean b=sts.execute(sql);
			System.out.println(b);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		public void db_insert(int id,String name){
			Connection conn=null;
			Statement sts=null;
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				sts=conn.createStatement();
				String sql="insert into stu values("+id+",'"+name+"')";
//			boolean b=sts.execute(sql);//false
//			System.out.println(b);
				int n=sts.executeUpdate(sql);
				System.out.println(n);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(sts!=null)sts.close();
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
		Statement sts=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			sts=conn.createStatement();
			String sql="insert into stu values(7,'zhansan')";
//			boolean b=sts.execute(sql);//false
//			System.out.println(b);
			int n=sts.executeUpdate(sql);
			System.out.println(n);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Test
	public void db_select(){
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/briup";
		String user="root";
		String password="";
		Connection conn=null;
		Statement sts=null;
		ResultSet rs=null;
		//第一步注册驱动
		try {
			Class.forName(driver);
			//第二部获取链接
			conn=DriverManager.getConnection(url, user, password);
			//第三步创建Statement对象
			sts=conn.createStatement();
			//第四步执行sql语句
			String sql="select * from stu";
			//executeQuery返回结果集
//			boolean b=sts.execute(sql);
//			System.out.println(b);
//			int s=sts.executeUpdate(sql);
//			System.out.println(s);
			rs=sts.executeQuery(sql);
			//第五步处理结果集
			while(rs.next()){
				//基于列的角标位置取值
//				int id=rs.getInt(1);
//				String name=rs.getString(2);
				//基于列的名字去取
				int id=rs.getInt("id");
				String name=rs.getString("name");
				System.out.println(id+"---"+name);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					//关闭资源倒着关
					if(rs!=null)rs.close();
					if(sts!=null)sts.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
