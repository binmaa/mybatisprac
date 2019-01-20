package com.binmaa.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binmaa.Test;

public class SqlSessionFactoryUtils {
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
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
