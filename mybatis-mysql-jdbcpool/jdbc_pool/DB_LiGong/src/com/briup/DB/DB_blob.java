package com.briup.DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.briup.Util.Model.JDBC_util;

/*
 * 存储二进制
 */
public class DB_blob {
	@Test	
	public void insert_img(){
		Connection conn=JDBC_util.getConn();
		PreparedStatement ps=null;
		String sql="insert into s_img values(?)";
		try {
			ps=conn.prepareStatement(sql);
			//ps.setBlob(1, inputStream);
			InputStream is=new FileInputStream(new File("src/com/briup/DB/2.jpg"));
			ps.setBinaryStream(1, is);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void select_img(){
		Connection conn=JDBC_util.getConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from s_img";
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()){
					InputStream is=rs.getBinaryStream(1);
					FileOutputStream fos=new FileOutputStream(
							new File("src/1.png"));
					byte[] b=new byte[1024];
					int len=0;
					while((len=is.read(b))!=-1){
						fos.write(b,0,len);
					}
					fos.flush();
					fos.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}





