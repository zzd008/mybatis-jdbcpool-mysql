package com.briup.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DB_batch {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/briup?user=root&password=";
	@Test
	public void batch_sts(){
		Connection conn=null;
		Statement sts=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			sts=conn.createStatement();
			for(int i=0;i<10000;i++){
			String sql="insert into stu values("+i+",'lisi"+i+"')";
			sts.execute(sql);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public void batch_ps1(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			String sql="insert into stu values(?,?)";
			//获取时间戳
			long start_date=System.currentTimeMillis();
			ps=conn.prepareStatement(sql);
			for(int i=0;i<14000;i++){
				ps.setInt(1, i);
				ps.setString(2, "briup"+i);
				//设置好的一组组数据加入缓存中
				ps.addBatch();
				if(i%10000==0){
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			long end_date=System.currentTimeMillis();
			System.out.println(end_date-start_date);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void batch_ps(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			String sql="insert into stu values(?,?)";
			//获取时间戳
			long start_date=System.currentTimeMillis();
			ps=conn.prepareStatement(sql);
			for(int i=12;i<=10000;i++){
				ps.setInt(1, i);
				ps.setString(2, "briup"+i);
				ps.execute();
			}
			long end_date=System.currentTimeMillis();
			System.out.println(end_date-start_date);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
