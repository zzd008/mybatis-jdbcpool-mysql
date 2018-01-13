package com.briup.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.briup.Util.Model.JDBC_util;

public class DB_tran {
	@Test
	public void tran_test(){
		Connection conn=JDBC_util.getConn();
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		Savepoint sp1=null;
		try {
			//设置事务手动提交   相当于命令set autocommit=off
			conn.setAutoCommit(false);
			//设置隔离级别的
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			Savepoint sp=conn.setSavepoint("sp");
			String sql="insert into tea values(11,'teestst')";
			sp1=conn.setSavepoint("sp1");
			ps=conn.prepareStatement(sql);
			String sql1="insert into tea values(12,'teestst')";
			ps1=conn.prepareStatement(sql1);
			String sql2="insert into tea values(13,'teestst')";
			ps2=conn.prepareStatement(sql2);
			ps.execute();
			ps1.execute();
			ps2.execute();
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				conn.commit();
				e.printStackTrace();
				conn.rollback(sp1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					//资源的关闭不会导致数据的提交
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}










