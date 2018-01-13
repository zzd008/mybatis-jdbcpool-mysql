package com.briup.DB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.briup.Util.Model.JDBC_util;

public class DB_resultSet {
	/*
	 * 元数据的操作
	 */
	@Test
	public void db_res3(){
		Connection conn=JDBC_util.getConn();
		String sql="select * from s_emp";
		//获取连接对象的元数据
//		try {
//			DatabaseMetaData data=conn.getMetaData();
//			System.out.println(data.getDriverVersion());
//			System.out.println(data.getURL());
//			System.out.println(data.getDatabaseProductName());
//			System.out.println(data.getDefaultTransactionIsolation());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			//ResultSetMetaData psd=ps.getMetaData();
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			//描述结果集中有多少列
			System.out.println(rsmd.getColumnCount());
			//获取结果集中列的名字
			System.out.println(rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnLabel(1));
			//获取结果集中对应java中的类型
			System.out.println(rsmd.getColumnClassName(1));
			List<Map<String, Object>> list=new ArrayList<>();
			int num=rsmd.getColumnCount();
			while(rs.next()){
				Map<String, Object> map=new HashMap<>();
				for(int i=1;i<=num;i++){
					map.put(rsmd.getColumnName(i),
							rs.getObject(i));
				}
				list.add(map);
			}
			System.out.println(list.size());
			for(Map<String, Object> m:list){
				System.out.println("--------------------");
				for(Entry<String, Object> en:m.entrySet()){
					System.out.println(en.getKey()+"**"+en.getValue());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void db_res2(){
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea";
		//Statement ps=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn.setTransactionIsolation(
					Connection.TRANSACTION_READ_UNCOMMITTED);
			//对查询出的结果集修改会同步修改到数据库中
			//ResultSet.CONCUR_UPDATABLE
			ps=
					conn.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_UPDATABLE
							);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"---"+rs.getString(2));
				if(rs.getInt(1)==3){
					//更改数据的同时同步到数据库和下面结合使用
					//ResultSet.CONCUR_UPDATABLE
					rs.updateString(2, "zhangsan_");
					rs.updateRow();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	public void db_res1(){
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn.setTransactionIsolation(
					Connection.TRANSACTION_READ_UNCOMMITTED);
			ps=
					conn.prepareStatement(sql,
							ResultSet.CONCUR_READ_ONLY
							,ResultSet.TYPE_SCROLL_SENSITIVE);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"---"+rs.getString(2));
				Thread.sleep(4000);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void db_res(){
		Connection conn=JDBC_util.getConn();
		String sql="select * from tea";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+"---"+rs.getString(2));
			}
			System.out.println("-----------------------");
			while(rs.previous()){
				System.out.println(rs.getInt(1)+"---"+rs.getString(2));
			}
			//直接定位到某一行,定位有这行true，否则false
			boolean b=rs.absolute(3);
			System.out.println(b);
			System.out.println(rs.getInt(1)+"---"+rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
