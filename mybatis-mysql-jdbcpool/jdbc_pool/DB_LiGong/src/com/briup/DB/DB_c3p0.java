package com.briup.DB;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DB_c3p0 {
	@Test
	public void c3p0_test(){
		ComboPooledDataSource pool=
				new ComboPooledDataSource("hello");
		try {
			Connection conn=pool.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
