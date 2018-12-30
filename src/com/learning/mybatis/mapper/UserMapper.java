package com.learning.mybatis.mapper;

import java.util.List;

import com.learning.mybatis.pojo.QueryVO;
import com.learning.mybatis.pojo.User;

/**
 *�ĸ�ע���:1.��������xml��id��һ��
 *		 2.����ֵ���ͺ�resultTypeһ��
 * 		 3.��κ�parameterTypeһ��
 *		 4.xml��namespace����ΪMapper��������
 */
public interface UserMapper {

	public User findUserById(Integer id);
	
	public List<User> findUserByQueryVO(QueryVO queryVO);
	
	public Integer count();
	
	public List<User> findUserByUserNameandSex(User user);
	
	public List<User> findUserByArray(Integer[] ids);
	
	public List<User> findUserByList(List<Integer> idsList);
	
	public List<User> findUserByQueryList(QueryVO queryVO);
	
	public List<User> findUsers();
}
  