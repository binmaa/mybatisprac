package com.binmaa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binmaa.mapper.UserMapper;
import com.binmaa.pojo.Order;
import com.binmaa.pojo.QueryVo;
import com.binmaa.pojo.User;
import com.binmaa.util.SqlSessionFactoryUtils;

public class TestUserByMapper {
	private static Logger log = LoggerFactory.getLogger(TestUserByMapper.class);
	@Test
	public void test() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserByID(29);
		log.error(user.toString());
		sqlSession.close();
	}
	
	@Test
	public void getUserByQueryVo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		User user = new User();
		user.setUsername("张");
		queryVo.setUser(user);
		List<User> list = userMapper.getUserByQueryVo(queryVo);
		for (User u : list) {
			log.error(u.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void getUserByUser() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张");
		user.setSex("1");
		List<User> list = userMapper.getUserByUser(user);
		for (User u : list) {
			log.error(u.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void getUserByIds() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张");
		user.setSex("1");
		user.setId(29);
//		List<User> list = userMapper.getUserByIds(list2);
		List<User> list = userMapper.getUserByIds(Arrays.asList(28,29));
		for (User u : list) {
			log.error(u.toString());
		}
		sqlSession.close();
	}
	@Test
	public void getUserOrders() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.getUserOrders();
		for (User u : list) {
			log.error(u.toString());
			List<Order> orders = u.getOrders();
			log.error("\t\t当前用户订单数为："+orders.size()+"个");
			for (Order order : orders) {
				log.error("\t\t"+order.toString());
			}
		}
		sqlSession.close();
	}
	
	

}
