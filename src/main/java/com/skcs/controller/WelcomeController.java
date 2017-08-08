package com.skcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public ModelAndView mymethod(){
		String message = "WELCOME SPRING MVC";  
		return new ModelAndView("welcomepage", "message", message);  

	}
}
