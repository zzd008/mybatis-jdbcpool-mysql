package com.briup.Util.Model;
/*
 * 连接池
 * 享元模式
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class JDBC_Pool {
	//线程安全的集合
	private  Vector<Connection>  v=null;
	//初始放置多少个连接对象
	public JDBC_Pool(int init_num){
		try {
			v=new Vector<>(init_num);
			Properties pro=new Properties();
			pro.load(new FileInputStream(new File("src/com/briup/Util/Model/conn.txt")));
			for(int i=1;i<=init_num;i++){
				Class.forName(pro.getProperty("driver"));
				Connection conn=
						DriverManager.getConnection(pro.getProperty("url"),
								pro.getProperty("user"), pro.getProperty("password"));
				v.add(conn);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void relaseConn(Connection conn){
		v.add(conn);
	}
	
	public Connection getConn(){
		//init_num 20   v 0
		//最大连接数 50 超出人数wait 和notify
		Connection conn=null;
		if(v.size()>0){
			conn=v.get(0);
			v.remove(conn);
		}
		return conn;
	}
}









