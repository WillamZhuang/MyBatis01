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
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		Object result = sqlSession.selectOne("test.findUserById", 10);
		//6.打印结果
		System.out.println(result);
		//7.释放资源
	}
	
	/**
	 * 测试通过姓名模糊查询
	 * @throws Exception
	 */
	@Test
	public void testFindUserByName() throws Exception {
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		List<User> userList = sqlSession.selectList("test.findUserByName","小明");
		//6.打印结果
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	/**
	 * 添加一个用户
	 */
	@Test
	public void testInsertUser() throws Exception {
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		//创建对象
		User user = new User();
		user.setUsername("小绿");
		user.setAddress("北京");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.insertUser", user);
		//6.打印结果
		sqlSession.commit();
		System.out.println(user.getId());
	}
	/**
	 * 更新一个用户
	 */
	@Test
	public void testUpdateUser() throws Exception {
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		//创建对象
		User user = new User();
		user.setId(26);
		user.setUsername("小绿");
		user.setAddress("北京");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.updateUser", user);
		//6.打印结果
		sqlSession.commit();
	}
	/**
	 * 删除一个用户
	 */
	@Test
	public void testDeleteUser() throws Exception {
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		//创建对象
		sqlSession.insert("test.deleteUserById", 26);
		//6.打印结果
		sqlSession.commit();
	}
	
	/**
	 * 测试通过姓名模糊查询
	 * @throws Exception
	 */
	@Test
	public void testFindUserByQueryVO() throws Exception {
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//6.打印结果
		QueryVO queryVO = new QueryVO();
		User user  =  new User();
		user.setUsername("小明");
		queryVO.setUser(user);
		List<User> userList = userMapper.findUserByQueryVO(queryVO);
		for (User user2 : userList) {
			System.out.println(user2);
		}
	}
	
	/**
	 * 测试通过姓名模糊查询
	 * @throws Exception
	 */
	@Test
	public void testCountUser() throws Exception {
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//6.打印结果
		Integer count = userMapper.count();
		System.out.println(count);
	}
	
	/**
	 * 测试resultMap手动映射
	 */
	@Test
	public void findOrderList() throws Exception{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> resultList = orderMapper.findOrderList();
		for(Order order:resultList){
			System.out.println(order);
		}
	}
	/**
	 * 动态sql之if判断
	 * @throws Exception
	 */
	@Test
	public void findUserByUserNameandSex() throws Exception{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("张小明");
		List<User> userList = userMapper.findUserByUserNameandSex(user);
		for(User user2:userList){
			System.out.println(user2);
		}
	}
	/**
	 * 动态sql之foreach
	 * @throws Exception
	 */
	@Test
	public void findInList() throws Exception{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
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
	 * 一对一映射
	 */
	@Test
	public void findJoinedOrders() throws Exception{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> joinedOrderList = orderMapper.findJoinedOrderList();
		for(Order order:joinedOrderList){
			System.out.println(order);
		}
	}
	
	/**
	 * 一对多映射
	 */
	@Test
	public void findUsers() throws Exception{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载sqlConfig.xml文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//3.创建sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		//4.创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行sqlSession对象执行查询，获取结果User
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findUsers();
		for(User user:users){
			System.out.println(user);
		}
	}
	
}
