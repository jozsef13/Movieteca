package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.repository.OrderRepository;

@RestController
@RequestMapping(OrderController.CONTRACT_BASE_URL)
public class OrderController {
	
	public static final String CONTRACT_BASE_URL = "/order";
	@Autowired
	private OrderRepository orderRepo;
}
