package com.rest.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.request.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u where u.username=:username and u.password=:password ")
	User getUser(@Param("username") String username,@Param("password")  String password);


}
