package com.binmaa;

import static org.junit.Assert.*;

import java.sql.SQLFeatureNotSupportedException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binmaa.mapper.OrderMapper;
import com.binmaa.pojo.Order;
import com.binmaa.util.SqlSessionFactoryUtils;

public class TestOrder {
	private static Logger log = LoggerFactory.getLogger(TestOrder.class);

	@Test
	public void test() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		int numbers = mapper.getOrderNumbers();
		log.error(String.valueOf(numbers));
		sqlSession.close();
	}
	@Test
	public void getOrderList() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
//		List<Order> orderList = mapper.getOrderList();
		List<Order> orderList = mapper.getOrderListMap();
		for (Order order : orderList) {
			log.error(order.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void getOrderUser() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
//		List<Order> orderList = mapper.getOrderList();
		List<Order> orderList = mapper.getOrderUser();
		for (Order order : orderList) {
			log.error(order.toString());
			log.error("该订单的用户信息为："+order.getUser());
		}
		sqlSession.close();
	}
	
	

}
