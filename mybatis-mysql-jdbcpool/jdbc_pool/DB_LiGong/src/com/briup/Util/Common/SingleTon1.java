package com.briup.Util.Common;
/*
 * 饿汉模式
 */
public class SingleTon1 {
	private static SingleTon1 conn=new SingleTon1();
	private SingleTon1(){
		
	}
	public static SingleTon1 getSingleton(){
		return conn;
	}
}
