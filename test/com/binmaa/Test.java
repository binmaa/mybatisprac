package com.binmaa;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binmaa.pojo.User;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			//1.创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
			//2.创建核心配置文件输入流
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//3.通过输入流创建SqlSessionFactory
			sqlSessionFactory = factoryBuilder.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void getUserById() throws IOException {
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		//2.创建核心配置文件输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.通过输入流创建SqlSessionFactory
		SqlSessionFactory build = factoryBuilder.build(inputStream);
		//4.创建SqlSession对象
		SqlSession sqlSession = build.openSession();
		//5.查询
		User user = sqlSession.selectOne("user.getUserByID", 1);
		logger.error(user.toString());
		//6.释放资源
		sqlSession.close();
	}
	@org.junit.Test
	public void getUserByName(){
		SqlSession openSession = sqlSessionFactory.openSession();
//		List<User> userList = openSession.selectList("user.getUserByName", "%张%");
		List<User> userList = openSession.selectList("user.getUserByName", "张");
		for (User user : userList) {
			logger.error(user.toString());
		}
		openSession.close();
	}
	@org.junit.Test
	public void insertUser(){
		SqlSession openSession = sqlSessionFactory.openSession(true);
		User user = new User();
		user.setUsername("binmaa2");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("朝阳区");
		int insert = openSession.insert("insertUser", user);
		logger.error(user.toString());
		openSession.close();
	}
	@org.junit.Test
	public void updateUser(){
		SqlSession openSession = sqlSessionFactory.openSession(true);
		User user = new User();
		user.setId(36);
		user.setUsername("mabin");
		int insert = openSession.delete("updateUser", user);
		openSession.close();
	}
	@org.junit.Test
	public void deleteuser(){
		SqlSession openSession = sqlSessionFactory.openSession(true);
		int insert = openSession.delete("deleteUser", 32);
		openSession.close();
	}
	

}
