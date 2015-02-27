package com.rest.request.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.request.service.UserService;

public class CommonController {

	@Autowired
	public UserService userService;
	
}
