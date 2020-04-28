package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.application.MovietecaApplication;
import com.project.module.Cart;
import com.project.module.Movie;
import com.project.service.CartService;
import com.project.service.MovieService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private OrderController orderController;
	
	@GetMapping("/cart/{id}")
	public ModelAndView getCartById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("cart");
		Cart cart = cartService.getCartById(id);
		model.addObject(cart);
		return model;
	}
	
	public ModelAndView addMovieToCart(Movie movie, String type) {
		Cart cart = cartService.addMovieToCart(movie, type);
		ModelAndView model = getCartById(cart.getId());
		return model;
	}
	
	@RequestMapping(value = "/cart/deleteMovie/{id}")
	public ModelAndView delteMovieFromCart(@PathVariable int id) {
		ModelAndView model = new ModelAndView("cart");
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		Movie movie = movieService.getMovieById(id);
		Cart updatedCart = cartService.deleteMovieFromCart(movie, cart);
		model.addObject(updatedCart);
		return model;
	}
	
	@RequestMapping(value = "/cart/placeOrder/{cartId}")
	public ModelAndView placeOrder(@PathVariable int cartId) {
		Cart cart = cartService.getCartById(cartId);
		ModelAndView model = orderController.placeOrder(cart);
		cartService.deleteCart(cart);
		return model ;
	}

}
