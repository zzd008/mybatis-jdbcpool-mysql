package com.briup.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.bean.Phone;

public class PhoneTypeHandler extends BaseTypeHandler<Phone>{

	//查询中遇到Phone类型的应该如何封装(使用列名封装)
	@Override
	public Phone getNullableResult(ResultSet res, String columnName)
			throws SQLException {
		return new Phone(res.getString(columnName));
	}

	//查询中遇到Phone类型的应该如何封装(使用列的下标)
	@Override
	public Phone getNullableResult(ResultSet res, int index)
			throws SQLException {
		return new Phone(res.getString(index));
	}

	//CallableStatement使用中遇到了Phone类型的应该如何封装
	@Override
	public Phone getNullableResult(CallableStatement cs, int index)
			throws SQLException {
		return new Phone(cs.getString(index));
	}

	//遇到Phone参数的时候应该如何在ps中设置值
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			Phone phone, JdbcType jdbcType) throws SQLException {
		ps.setString(i, phone.toString());
	}
	
}
