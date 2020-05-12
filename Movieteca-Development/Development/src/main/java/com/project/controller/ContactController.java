package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ContactController {
	
	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {
		ModelAndView model = new ModelAndView("contact");
		return model;
	}
}
