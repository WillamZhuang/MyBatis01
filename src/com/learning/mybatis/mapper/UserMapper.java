package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.User;

/**
 *四个注意点:1.方法名与xml中id名一致
 *		 2.返回值类型和resultType一致
 * 		 3.入参和parameterType一致
 *		 4.xml中namespace设置为Mapper完整类名
 */
public interface UserMapper {

	public User findUserById(Integer id);
}
  