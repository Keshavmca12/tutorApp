package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView  loginPage(@RequestParam(value = "logout", required = false) String logout) {
		System.out.println("returning login page");
		 ModelAndView model = new ModelAndView();
		  if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		  }
		  model.setViewName("index");

		  return model;
		//return "index";
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
