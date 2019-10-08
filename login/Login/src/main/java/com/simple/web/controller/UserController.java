package com.simple.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.web.dto.User;
import com.simple.web.dto.UserRole;
import com.simple.web.service.api.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	public UserController() {}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUserList() {
		return this.userService.getUserList();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public User getUsernameAndPassword() {
		return this.userService.getUsernameAndPassword("admin", "123456");
	}
	
	@RequestMapping(value="/role", method = RequestMethod.GET)
	@ResponseBody
	public UserRole getUserRole(){
		return this.userService.getUsernameAndPassword("admin", "123456").getUserRole();
	}
}
