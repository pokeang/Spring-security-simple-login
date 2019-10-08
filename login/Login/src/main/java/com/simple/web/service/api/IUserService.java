package com.simple.web.service.api;

import java.util.List;

import com.simple.web.dto.User;

public interface IUserService {
	public User getUsernameAndPassword(String username, String password);
	public List<User> getUserList();
}