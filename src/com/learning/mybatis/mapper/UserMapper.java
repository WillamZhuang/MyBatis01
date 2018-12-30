package com.learning.mybatis.mapper;

import java.util.List;

import com.learning.mybatis.pojo.QueryVO;
import com.learning.mybatis.pojo.User;

/**
 *四个注意点:1.方法名与xml中id名一致
 *		 2.返回值类型和resultType一致
 * 		 3.入参和parameterType一致
 *		 4.xml中namespace设置为Mapper完整类名
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
  