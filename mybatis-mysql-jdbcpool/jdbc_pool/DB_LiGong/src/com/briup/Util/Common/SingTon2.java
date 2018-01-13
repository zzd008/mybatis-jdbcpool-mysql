package com.briup.Util.Common;
/*
 * 懒汉模式
 */
public class SingTon2 {
	private static SingTon2 conn=null;
	private SingTon2(){
		
	}
	public static SingTon2 getSingleton(){
		if(conn==null){
		synchronized (conn) {
		if(conn==null){
			conn=new SingTon2();
			}
		}
		}
		return conn;
	}
}
