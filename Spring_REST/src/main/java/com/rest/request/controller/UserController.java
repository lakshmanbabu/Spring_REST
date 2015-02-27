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
import com.rest.request.dto.RegistrationResponse;
import com.rest.request.dto.UserDto;

@Controller
@RequestMapping("/v1/rest")
public class UserController extends CommonController {

	@RequestMapping(value="/registration",method=RequestMethod.POST, headers = "content-type=application/json,application/xml",consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RegistrationResponse signup(@RequestBody UserDto userDto, Model model){
		
		RegistrationResponse response=new RegistrationResponse();
		System.out.println("Username::"+userDto.getUsername());

		userService.saveUserDetails(userDto);
		response.setStatus(Constant.REGISTRATION_SUCCESS);
		response.setMessage("User Details Saved Sucessfully");
		return response;
	}
}
