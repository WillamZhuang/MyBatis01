package com.learning.mybatis.dao;

import com.learning.mybatis.pojo.User;

public interface UserDao {
	
	public User selectUserById(Integer id);
}
