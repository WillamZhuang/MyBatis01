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
}
