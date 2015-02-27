package com.rest.request.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.request.common.CommonController;
import com.rest.request.common.Constant;
import com.rest.request.dto.LoginResponse;
import com.rest.request.dto.UserDto;
import com.rest.request.model.User;

@Controller
@RequestMapping("/v1/rest")
public class LoginController extends CommonController {

	@RequestMapping(value="/login",method=RequestMethod.POST, headers = "content-type=application/json,application/xml",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LoginResponse login(@RequestBody UserDto userDto, Model model){
		
		LoginResponse response=new LoginResponse();
		System.out.println("Login page..");
		if(userDto.getUsername()!=null && userDto.getPassword()!=null){
			
			User user=userService.getUser(userDto.getUsername(),userDto.getPassword());
			if(user!=null){
				response.setStatus(Constant.LOGIN_SUCCESS);
				response.setMessage("Login Sucess!");
			}else{
				response.setStatus(Constant.LOGIN_FAILURE);
				response.setMessage("Login Failure!");
			}
		}
		
		return response;
	}
}
