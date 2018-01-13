package com.briup.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.junit.Test;

/*
 * 执行存储过程的操作
 */
public class CallableStatement_Test {
		private String driver="com.mysql.jdbc.Driver";
		private String url="jdbc:mysql://localhost:3306/briup?user=root&password=";
		
		/*
		 * 返回的是一个值
		 */
		@Test
		public void call_select(){
			Connection conn=null;
			CallableStatement cs=null;
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url);
				String sql="{call pr4(?,?)}";
				cs=conn.prepareCall(sql);
				cs.setInt(1, 100);
				//设置返回输出参数的类型
				cs.registerOutParameter(2, Types.INTEGER);
				//执行存储过程
				cs.execute();
				//获取结果
				int sum=cs.getInt(2);
				System.out.println(sum);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(cs!=null)cs.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		/*
		 * 返回的是一个结果集
		 */
		@Test
		public void call_selectall(){
			Connection conn=null;
			CallableStatement cs=null;
			ResultSet rs=null;
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url);
				String sql="{call pr5()}";
				cs=conn.prepareCall(sql);
				cs.execute();
				rs=cs.getResultSet();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					System.out.println(id+"--"+name);
				}
				//可省
//				if(cs.getMoreResults()){
//					cs.getResultSet();
//				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(cs!=null)cs.close();
					if(conn!=null)conn.close();
					if(rs!=null)rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
