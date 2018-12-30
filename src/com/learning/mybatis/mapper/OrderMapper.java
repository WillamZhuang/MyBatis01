package com.learning.mybatis.mapper;

import java.util.List;

import com.learning.mybatis.pojo.Order;

public interface OrderMapper {
	
	public List<Order> findOrderList();
	
	public List<Order> findJoinedOrderList();

}
