package com.example.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/unit")
	public ModelAndView limit() {
		/*SecurityC*/
	//	SecurityContext context = SecurityContextHolder.getContext();
		//System.out.println("SecurityContext  :  " + context);
	//	Authentication authentication = context.getAuthentication();
		System.out.println("Authentication : " + authentication);
		System.out.println("UserName : " + authentication.getName());
		System.out.println("Credentials :" + authentication.getCredentials());
		Collection<? extends GrantedAuthority> auth = authentication.getAuthorities();

		System.out.println("GrantedAuthority : " + auth);

		// Authorization Policy Logic Here
		for (GrantedAuthority auth1 : authentication.getAuthorities()) {
			System.out.println("Role :" + auth1);
			String authorization = auth1.getAuthority();
			System.out.println("Role :" + authorization);
			if ("ROLE_ADMIN".equalsIgnoreCase(authorization)) {
				System.out.println("Going to redirect to admin Page");
				return new ModelAndView("admin");
			} else if ("ROLE_USER".equalsIgnoreCase(authorization)) {
				System.out.println("Going to redirect to User Page");
				return new ModelAndView("user");
			} else {
				System.out.println("Going to redirect to DBA Page");
				return new ModelAndView("dba");
			}

		}
		return new ModelAndView("limit");
	}
}
