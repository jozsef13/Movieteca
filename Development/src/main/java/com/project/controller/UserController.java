package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@GetMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("login");
		return model ;
	}
	
	@GetMapping("/signup")
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("signup");
		return model;
	}
}
