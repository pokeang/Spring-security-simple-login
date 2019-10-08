package com.simple.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.simple.web.dto.User;

public interface UserDAO {
	public User getUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	public List<User> getUserList();

}