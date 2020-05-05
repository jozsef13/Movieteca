package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Provider;
import com.project.service.ProviderService;

@RestController
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	@PostMapping("/addProvider")
	public ModelAndView createProvider(Provider provider) {
		ModelAndView model = new ModelAndView("myaccount");
		providerService.addProvider(provider);
		model.addObject(provider);
		return model;
	}
	
	@GetMapping("/provider/{id}")
	public ModelAndView getProviderById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("myaccount");
		model.addObject(providerService.getProviderById(id));
		return model;
	}
}
