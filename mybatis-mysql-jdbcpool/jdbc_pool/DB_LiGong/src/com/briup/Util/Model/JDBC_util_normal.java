package com.briup.Util.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_util_normal {
		public void closePs(PreparedStatement  sts,Connection conn){
			closePs(null, sts,conn);
		}
		public void closePs(ResultSet rs,PreparedStatement  sts,Connection conn){
			try {
				if(rs!=null)rs.close();
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void closeSts(Statement sts,Connection conn){
			closeSts(null, sts, conn);
		}
		public void closeSts(ResultSet rs,Statement sts,Connection conn){
			try {
				if(rs!=null)rs.close();
				if(sts!=null)sts.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static Connection getConn(){
			Connection conn=null;
			try {
				Properties pro=new Properties();
				pro.load(new FileReader(new File("src/com/briup/Util/Model/conn.txt")));
				Class.forName(pro.getProperty("driver"));
				conn=DriverManager.getConnection(pro.getProperty("url"), 
						pro.getProperty("user"), pro.getProperty("password"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
}
