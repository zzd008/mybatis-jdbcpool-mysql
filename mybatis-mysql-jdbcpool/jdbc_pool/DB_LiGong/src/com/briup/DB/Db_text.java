package com.briup.DB;
/*
 * 关于Text数据类型的操作
 * 1，存储字符串
 * 2，存储文件
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class Db_text {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/briup?user=root&password=";
	@Test
	public void text_String(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			String sql="insert into tex values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, "testhello");
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
	public void text_writefile(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			String sql="insert into tex values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			//针对的是文件中只能存放字母，不能
			//出现中文
			//ps.setAsciiStream(parameterIndex, x);
			FileReader reader=new FileReader(
					new File("src/mysql.txt"));
			ps.setCharacterStream(2, reader);
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
	public void text_readfile(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
			String sql="select * from tex";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				Reader reader=rs.getCharacterStream(2);
				PrintWriter pw=new PrintWriter(
						new File("src/test.txt"));
				int len=0;
				char[] b=new char[1024];
				while((len=reader.read(b))!=-1){
					pw.write(b, 0, len);
				}
				pw.flush();
				pw.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}






