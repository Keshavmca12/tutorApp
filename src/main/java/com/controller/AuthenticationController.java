package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	private static final  Logger logger=Logger.getLogger(AuthenticationController.class);
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String  loginPage() {
		logger.info("returning login page");
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
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
		
	}
	
	@RequestMapping(value = { "/", "/home"}, method = RequestMethod.GET)
	public String homeAction(ModelMap model) {
		logger.info("returning home page");
		return "home";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		logger.info("serving accessDenied page");
		return "403";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentPage() {
		logger.info("serving student page");
		return "student";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage() {
		logger.info("serving register page");
		return "register";
	}
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String getTeacherPage() {
		logger.info("serving teacher page");
		return "teacher";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		logger.info("serving admin page");
		return "admin";
	}
	

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
