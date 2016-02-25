package com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dao.UserDao;
import com.dto.User;
import com.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService uerService;
	
	
	@RequestMapping(value = "/submitUserDetails", method = RequestMethod.POST)
	public   @ResponseBody String  submitUserDetails(@RequestBody User user) {
		System.out.println("submitUserDetails  :"+user);
		/*ObjectMapper obj=new ObjectMapper();
		User user=null;
		try {
			user = obj.readValue(userString, User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("user name"+user.getName());
		try {
			uerService.manipulateUserObject(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
