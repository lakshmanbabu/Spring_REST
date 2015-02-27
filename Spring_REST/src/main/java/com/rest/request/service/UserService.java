package com.rest.request.service;

import com.rest.request.dto.UserDto;
import com.rest.request.model.User;

public interface UserService {

	public void saveUserDetails(UserDto userDto);

	public User getUser(String username, String password);

}
