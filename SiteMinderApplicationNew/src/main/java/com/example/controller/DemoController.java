package com.example.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.CustomUser;

@Controller
public class DemoController {

	
	
	@RequestMapping("/unit")
	public ModelAndView limit(){
		CustomUser user=new CustomUser();
		Authentication principal = SecurityContextHolder.getContext().getAuthentication();
		
		 SecurityContext context = SecurityContextHolder.getContext();
		 System.out.println("SecurityContext"+context);
	        Authentication authentication = context.getAuthentication();
	        System.out.println("Authentication"+authentication);
	        //to get UserName
	          System.out.println("UserName : "+authentication.getName());
	          System.out.println("Credentials :"+authentication.getCredentials());
	        Collection<? extends GrantedAuthority> auth= authentication.getAuthorities();
	     
	        System.out.println("GrantedAuthority"+auth);
	        
	        
	        
	        
	        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().
					getAuthentication().getPrincipal();
			System.out.println("Password :"+userDetails.getPassword());
			System.out.println("UserName :"+userDetails.getUsername());
			System.out.println("Is Authentication Enabled :"+userDetails.isEnabled());
			
			
	        //Authorization Policy Logic Here
	        for (GrantedAuthority auth1 : authentication.getAuthorities()) {
	        	//to Get Granted Authority Name
	        	System.out.println("Role "+auth1);
	        	if(auth1.equals("ROLE_ADMIN_ROLE"))
	        	{
	        		System.out.println("Going to redirect to admin Page");
	        		return new ModelAndView("admin");
	        	}
	           if(auth1.equals("ROLE_SANDEEP"))
	        	{
	        		System.out.println("Going to redirect to User Page");
	        		return new ModelAndView("user");
	        	}
	        	else
	        	{
	        		System.out.println("Going to redirect to DBA Page");
	        		return new ModelAndView("dba");
	        	}
	        	
	        }

		/*if (principal instanceof CustomUser) {
			//CustomUser user = ((CustomUser)principal);
			System.out.println(user);
			String name = user.getUsername();
			System.out.println("User Name:"+name);
		System.out.println(principal);
		}
		else
		{
			//CustomUser user = ((CustomUser)principal);
			//System.out.println(user);
			//String name = user.getUsername();
			//System.out.println("User Name:"+name);
		}
		principal.toString();
		System.out.println(principal.toString());
		System.out.println("inside limit");
		System.out.println(principal);
		
		user.getUsername();
		user.getPassword();
		
		*/
		return new ModelAndView("limit");
	}
	
	@RequestMapping("/unitone")
	public String limitone(){
		System.out.println("inside limit");
		return "limit";
	}
}
