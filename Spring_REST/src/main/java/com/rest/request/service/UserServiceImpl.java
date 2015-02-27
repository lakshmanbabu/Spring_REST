package com.rest.request.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.request.dto.UserDto;
import com.rest.request.model.User;
import com.rest.request.model.UserRoles;
import com.rest.request.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public void saveUserDetails(UserDto userDto) {
		
		User user=new User();
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setGender(userDto.getGender());
		user.setUserRole(userDto.getUserRole());
		user.setContactno(userDto.getContactno());
		user.setEnabled(true);
		user.setCreatedDate(new Date());
		
		Set<UserRoles> roles=new HashSet<UserRoles>();
		UserRoles  userRoles=new UserRoles();
		userRoles.setAuthority(userDto.getUserRole());
		userRoles.setUser(user);
		roles.add(userRoles);
		user.setUserRoles(roles);
		
		userRepository.save(user);
	}

	@Override
	public User getUser(String username, String password) {
		
		User user=userRepository.getUser(username,password);
		
		return user;
	}

}
