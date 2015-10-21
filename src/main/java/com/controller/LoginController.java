package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String, String>  login(HttpServletRequest request,HttpSession session)
	{
		Map<String, String> response=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username :: "+username +"  password ::"+password);
		try {
			response=userService.verifyUser(password,session,username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
