package com.learning.mybatis.pojo.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.learning.mybatis.pojo.User;

public class TestDemo {

	@Test
	public void testMethod() throws Exception {
		//1.����sqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlConfig.xml�ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.����sqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.����sqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.ִ��sqlSession����ִ�в�ѯ����ȡ���User
		Object result = sqlSession.selectOne("test.findUserById", 10);
		//6.��ӡ���
		System.out.println(result);
		//7.�ͷ���Դ
	}
	
	/**
	 * ����ͨ������ģ����ѯ
	 * @throws Exception
	 */
	@Test
	public void testFindUserByName() throws Exception {
		//1.����sqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlConfig.xml�ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.����sqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.����sqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.ִ��sqlSession����ִ�в�ѯ����ȡ���User
		List<User> userList = sqlSession.selectList("test.findUserByName","С��");
		//6.��ӡ���
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * ���һ���û�
	 */
	@Test
	public void testInsertUser() throws Exception {
		//1.����sqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlConfig.xml�ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.����sqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.����sqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.ִ��sqlSession����ִ�в�ѯ����ȡ���User
		//��������
		User user = new User();
		user.setUsername("С��");
		user.setAddress("����");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.insertUser", user);
		//6.��ӡ���
		sqlSession.commit();
		System.out.println(user.getId());
	}
}
