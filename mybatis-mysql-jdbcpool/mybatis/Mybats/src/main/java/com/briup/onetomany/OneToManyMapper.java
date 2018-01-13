package com.briup.onetomany;

import com.briup.bean.Order;
import com.briup.bean.User;

public interface OneToManyMapper {

	void saveUser(User u);
	void saveOrder(Order o);
	//查询订单所属的用户
	User findAllOrders(int id);
	//查询订单信息
	Order findOrderById(int id);
}
