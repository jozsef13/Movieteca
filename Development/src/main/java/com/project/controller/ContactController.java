package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.application.MovietecaApplication;
import com.project.module.Cart;
import com.project.service.CartService;

@RestController
public class ContactController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {
		ModelAndView model = new ModelAndView("contact");
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if(cart != null) {
			model.addObject(cart);
		}
		return model;
	}
}
