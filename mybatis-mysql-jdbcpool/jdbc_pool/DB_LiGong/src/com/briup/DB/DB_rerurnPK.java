package com.briup.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.briup.Util.Model.JDBC_util;

public class DB_rerurnPK {
	@Test
	public void return_pk(){
		Connection conn=JDBC_util.getConn();
		PreparedStatement ps=null;
		String sql="insert into s_a(name,age) values(?,?)";
		try {
			ps=conn.prepareStatement(sql
					,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "lisi");
			ps.setInt(2, 30);
			ps.execute();
			
			//获取主键的结果集
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}




