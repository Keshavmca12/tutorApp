package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String  loginPage() {
		System.out.println("returning login page");
		 ModelAndView model = new ModelAndView();
		  if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		  }
		  model.setViewName("login");

		  return model;
		return "login";
		//return "index";
	}
*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String printHello(HttpServletRequest request, HttpServletResponse response) {
		
		return "login"; // directed to tiles.xml
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeAction(ModelMap model) {
		System.out.println("returning home page");
		return "home";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		System.out.println("serving accessDenied page");
		return "403";
	}
}
