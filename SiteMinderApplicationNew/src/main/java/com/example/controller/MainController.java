package com.example.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.CustomUser;

@RestController
@RequestMapping("/admin")
public class MainController {

	
	/*CustomUser user=new CustomUser();
	@RequestMapping(value="/u")
	public String securedHome() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println("Before call="+principal);
		if (principal instanceof CustomUser) {
		user = ((CustomUser)principal);
		System.out.println(user);
		String name = user.getUsername();
		System.out.println("User Name:"+name);
		//model.addAttribute("username", name);
		}else{
			user = ((CustomUser)principal);
			System.out.println(user);
			String name = user.getUsername();
			System.out.println("User Name:"+name);
			System.out.println("okay");
			
		}
	//model.addAttribute("message", "Welcome to the secured page through site minder");
	//return new ModelAndView("home");
		return "home.jsp";
	}
	*/
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public ModelAndView show()
	{
		System.out.println("In Controller: show()");
		return new ModelAndView("homee");
	}

	
}
