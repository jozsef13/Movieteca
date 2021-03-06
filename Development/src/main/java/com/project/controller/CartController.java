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
import com.project.module.Movie;
import com.project.module.MyUserDetails;
import com.project.service.CartService;
import com.project.service.MovieService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/cart/{id}")
	public ModelAndView getCartById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("cart");
		Cart cart = cartService.getCartById(id);
		model.addObject(cart);
		return model;
	}
	
	@RequestMapping(value = "/cart/deleteMovie/{id}")
	public ModelAndView delteMovieFromCart(@PathVariable int id, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("cart");
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Customer customer = (Customer) userDetails.getUser();
		Cart cart = customer.getCart();
		Movie movie = movieService.getMovieById(id);
		Cart updatedCart = cartService.deleteMovieFromCart(movie, cart);
		customer.setCart(updatedCart);
		userDetails.setUser(customer);
		model.addObject(updatedCart);
		return model;
	}
	
	@GetMapping("/addToCart/Movie/{id}")
	public ModelAndView addMovieToCart(@PathVariable int id, HttpServletRequest request) {
		String type = request.getParameter("orderType");
		String quantity = request.getParameter("orderQuantity");
		int quantityInt = 1;
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(quantity != null) {
			quantityInt = Integer.parseInt(quantity);
		}
		Movie movie = movieService.getMovieById(id);
		Customer customer = (Customer) userDetails.getUser();
		Cart cart = cartService.addMovieToCart(movie, type, quantityInt, customer);
		customer.setCart(cart);
		userDetails.setUser(customer);
		ModelAndView model = new ModelAndView("cart");
		model.addObject(cart);
		return model;
	}
	
	@GetMapping("/cart/updateMovieQuantity/{id}")
	public ModelAndView updateCart(@PathVariable int id, HttpServletRequest request) {
		String quantity = request.getParameter("orderQuantity");
		int quantityInt = Integer.parseInt(quantity);
		Movie movie = movieService.getMovieById(id);
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Customer customer = (Customer) userDetails.getUser();
		Cart updatedCart = cartService.update(movie, customer.getCart().getId(), quantityInt);
		customer.setCart(updatedCart);
		userDetails.setUser(customer);
		ModelAndView model = new ModelAndView("cart");
		model.addObject("cart", updatedCart);
		return model;
	}
	
	@GetMapping("/cart/updateType/{id}")
	public ModelAndView updateTypeFromCart(@PathVariable int id, HttpServletRequest request) {
		String type = request.getParameter("orderType");
		Movie movie = movieService.getMovieById(id);
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Customer customer = (Customer) userDetails.getUser();
		Cart updatedCart = cartService.updateType(movie, customer.getCart().getId(), type);
		customer.setCart(updatedCart);
		userDetails.setUser(customer);
		ModelAndView model = new ModelAndView("cart");
		model.addObject(updatedCart);
		return model;
	}
	
	@GetMapping("/cart/checkout/{id}")
	public ModelAndView checkout(@PathVariable int id) {
		ModelAndView model = new ModelAndView("checkout");
		Cart cart = cartService.getCartById(id);
		model.addObject(cart);
		return model ;
	}
}
