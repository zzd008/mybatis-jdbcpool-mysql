package com.briup.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.briup.Util.Model.JDBC_Pool;

/*
 * 处理时间的
 */
public class DB_date {
	public static void main(String[] args) {
		//3918-01-19
//		Date date=new Date(2017-1900,12-1, 19);
//		System.out.println(date);
//		Date date=new Date();
		//注意，不管什么类型时间转化都是用时间戳。
//		System.out.println(date.getTime());
//		System.out.println(new java.sql.Date(date.getTime()));
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		//将字符串转化为时间
		String str="1999-12-11";
		try {
			Date date=format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将时间(java.sql或java.util)转化为字符串
		String da=format.format(new java.sql.Date(new Date().getTime()));
		System.out.println(da);
	}
	public void ps_date(){
		Connection conn=new JDBC_Pool(5).getConn();
		PreparedStatement ps=null;
		try {
			String sql="insert into s_date values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setDate(2, new java.sql.Date(new Date().getTime()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void sts_date(){
		Connection conn=new JDBC_Pool(5).getConn();
		try {
			Statement sts=conn.createStatement();
			//String sql="insert into s_date values(1,'"+new java.sql.Date(new Date().getTime())+"')";
			String sql="insert into s_date values(2,'1997-12-11')";
			sts.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}









