package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.repository.CartRepository;

@RestController
@RequestMapping(CartController.CONTRACT_BASE_URL)
public class CartController {
	
	public static final String CONTRACT_BASE_URL = "/cart";
	@Autowired
	private CartRepository cartRepo;
}
