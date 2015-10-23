package com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.map.ObjectMapper;

import com.dao.UserDao;
import com.dto.User;
import com.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/employeeForm", method = RequestMethod.GET)
	public String smartTable() {
		System.out.println("serving employeeForm page");
		return "employeeForm";
	}

	@RequestMapping(value = "/submitUserDetails", method = RequestMethod.POST)
	public   @ResponseBody HashMap<String, Object>  submitUserDetails(@RequestParam("user") String userString) {
		System.out.println("submitUserDetails   userString :"+userString);
		ObjectMapper obj=new ObjectMapper();
		User user=null;
		HashMap<String, Object> response=null;
		try {
			user = obj.readValue(userString, User.class);
			System.out.println("user name"+user.getName());
			response=userService.manipulateUserObject(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
