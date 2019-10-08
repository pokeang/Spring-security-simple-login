package com.simple.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.simple.web.dao.UserDAO;
import com.simple.web.dto.User;
import com.simple.web.service.api.IUserService;

public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDAO userDAO;

	public UserServiceImpl(){}

	@Override
	public User getUsernameAndPassword(String username, String password) {
		return this.userDAO.getUsernameAndPassword(username, password);
	}

	@Override
	public List<User> getUserList() {
		return this.userDAO.getUserList();
	}
	
}