package com.binmaa.mapper;

import java.util.List;

import com.binmaa.pojo.Order;
import com.binmaa.pojo.User;

public interface OrderMapper {
	List<Order> getOrderList();
	int getOrderNumbers();
	List<Order> getOrderListMap();
	List<Order> getOrderUser();
}
