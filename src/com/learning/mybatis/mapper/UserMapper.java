package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.User;

/**
 *�ĸ�ע���:1.��������xml��id��һ��
 *		 2.����ֵ���ͺ�resultTypeһ��
 * 		 3.��κ�parameterTypeһ��
 *		 4.xml��namespace����ΪMapper��������
 */
public interface UserMapper {

	public User findUserById(Integer id);
}
  