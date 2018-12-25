package com.learning.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.learning.mybatis.dao.UserDaoImpl;
import com.learning.mybatis.pojo.User;

public class UserDaoImpTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception{
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
	}
	@Test
	public void selectUserTest(){
		UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
}
