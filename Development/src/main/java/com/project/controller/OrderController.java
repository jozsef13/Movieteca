package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.application.MovietecaApplication;
import com.project.module.Cart;
import com.project.module.Order;
import com.project.service.CartService;
import com.project.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/cart/placeOrder/{cartId}")
	public ModelAndView placeOrder(@PathVariable int cartId) {
		ModelAndView model = new ModelAndView("thankyou");
		Cart cart = cartService.getCartById(cartId);
		Order order = orderService.placeOrder(cart);
		cartService.deleteCart(cart);
		model.addObject(order);
		return model;
	}
	
	@GetMapping("/order/status/{id}")
	public ModelAndView getOrderStatusById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("orderstatus");
		Order order = orderService.getOrderById(id);
		model.addObject(order);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if(cart != null) {
			model.addObject(cart);
		}
		return model;
	}
	
	@GetMapping("/order/{id}")
	public ModelAndView getOrderDetailsById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("orderdetails");
		Order order = orderService.getOrderById(id);
		model.addObject(order);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if(cart != null) {
			model.addObject(cart);
		}
		return model;
	}
	
}
