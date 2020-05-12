package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Cart;
import com.project.module.Customer;
import com.project.module.MyUserDetails;
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
	public ModelAndView placeOrder(@PathVariable int cartId, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("thankyou");
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = (Customer) userDetails.getUser();
		Cart cart = cartService.getCartById(cartId);
		Order order = orderService.placeOrder(cart);
		cartService.deleteCart(cart, customer);
		model.addObject(order);
		return model;
	}
	
	@GetMapping("/order/status/{id}")
	public ModelAndView getOrderStatusById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("orderstatus");
		Order order = orderService.getOrderById(id);
		model.addObject(order);
		return model;
	}
	
	@GetMapping("/order/{id}")
	public ModelAndView getOrderDetailsById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("orderdetails");
		Order order = orderService.getOrderById(id);
		model.addObject(order);
		return model;
	}
	
}
