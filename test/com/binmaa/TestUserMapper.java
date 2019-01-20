package com.binmaa;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binmaa.dao.UserMapper;
import com.binmaa.pojo.User;
import com.binmaa.util.SqlSessionFactoryUtils;

public class TestUserMapper {
	private static Logger log = LoggerFactory.getLogger(TestUserMapper.class);
	@Test
	public void test() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserByID(29);
		log.error(user.toString());
		sqlSession.close();
	}

}
