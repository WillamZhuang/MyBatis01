package com.learning.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.learning.mybatis.mapper.OrderMapper;
import com.learning.mybatis.mapper.UserMapper;
import com.learning.mybatis.pojo.Order;
import com.learning.mybatis.pojo.QueryVO;
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
	/**
	 * ����һ���û�
	 */
	@Test
	public void testUpdateUser() throws Exception {
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
		user.setId(26);
		user.setUsername("С��");
		user.setAddress("����");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.updateUser", user);
		//6.��ӡ���
		sqlSession.commit();
	}
	/**
	 * ɾ��һ���û�
	 */
	@Test
	public void testDeleteUser() throws Exception {
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
		sqlSession.insert("test.deleteUserById", 26);
		//6.��ӡ���
		sqlSession.commit();
	}
	
	/**
	 * ����ͨ������ģ����ѯ
	 * @throws Exception
	 */
	@Test
	public void testFindUserByQueryVO() throws Exception {
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
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//6.��ӡ���
		QueryVO queryVO = new QueryVO();
		User user  =  new User();
		user.setUsername("С��");
		queryVO.setUser(user);
		List<User> userList = userMapper.findUserByQueryVO(queryVO);
		for (User user2 : userList) {
			System.out.println(user2);
		}
	}
	
	/**
	 * ����ͨ������ģ����ѯ
	 * @throws Exception
	 */
	@Test
	public void testCountUser() throws Exception {
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
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//6.��ӡ���
		Integer count = userMapper.count();
		System.out.println(count);
	}
	
	/**
	 * ����resultMap�ֶ�ӳ��
	 */
	@Test
	public void findOrderList() throws Exception{
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
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> resultList = orderMapper.findOrderList();
		for(Order order:resultList){
			System.out.println(order);
		}
	}
	/**
	 * ��̬sql֮if�ж�
	 * @throws Exception
	 */
	@Test
	public void findUserByUserNameandSex() throws Exception{
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
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("��С��");
		List<User> userList = userMapper.findUserByUserNameandSex(user);
		for(User user2:userList){
			System.out.println(user2);
		}
	}
	/**
	 * ��̬sql֮foreach
	 * @throws Exception
	 */
	@Test
	public void findInList() throws Exception{
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
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		QueryVO queryVO = new QueryVO();
		List<Integer> idsList = new ArrayList<>();
		idsList.add(1);
		idsList.add(10);
		idsList.add(16);
//		queryVO.setIdsList(idsList);
		
//		Integer[] ids = new Integer[3];
//		ids[0]=1;
//		ids[1]=10;
//		ids[2]=16;
		
//		queryVO.setIds(ids);
//		List<User> userList = userMapper.findUserByQueryList(queryVO);
		List<User> userArrays = userMapper.findUserByList(idsList);
		for(User user2:userArrays){
			System.out.println(user2);
		}
	}
	/**
	 * һ��һӳ��
	 */
	@Test
	public void findJoinedOrders() throws Exception{
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
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> joinedOrderList = orderMapper.findJoinedOrderList();
		for(Order order:joinedOrderList){
			System.out.println(order);
		}
	}
	
	/**
	 * һ�Զ�ӳ��
	 */
	@Test
	public void findUsers() throws Exception{
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
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findUsers();
		for(User user:users){
			System.out.println(user);
		}
	}
	
}
