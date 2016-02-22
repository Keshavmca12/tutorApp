package com.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	 private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	 
	 
	    /*
	     * This method extracts the roles of currently logged-in user and returns
	     * appropriate URL according to his/her role.
	     */
	    protected String determineTargetUrl(Authentication authentication) {
	        String url = "";
	 
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	 
	        List<String> roles = new ArrayList<String>();
	 
	        for (GrantedAuthority a : authorities) {
	            roles.add(a.getAuthority());
	        }
	 
	       /* if (isDba(roles)) {
	            url = "/db";
	        } else if (isAdmin(roles)) {
	            url = "/admin";
	        } else if (isUser(roles)) {
	            url = "/home";
	        } else {
	            url = "/accessDenied";
	        }*/
	 
	        return url;
	    }
	 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	 
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }

		@Override
		public void onAuthenticationSuccess(HttpServletRequest request,
				HttpServletResponse response, Authentication authentication)
				throws IOException, ServletException {
			 String targetUrl = determineTargetUrl(authentication);
			 
		        if (response.isCommitted()) {
		            System.out.println("Can't redirect");
		            return;
		        }
		 
		        redirectStrategy.sendRedirect(request, response, targetUrl);
		}

}
