package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.application.MovietecaApplication;
import com.project.module.Cart;
import com.project.module.Movie;
import com.project.service.CartService;
import com.project.service.MovieService;

@RestController
public class HomeController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("index");
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if(cart != null) {
			model.addObject(cart);
		}
		Movie movie = movieService.getMovieById(1);
		if(movie != null) {
			model.addObject(movie);
		}
		List<Movie> moviesList = movieService.getAllMovies();
		if(!moviesList.isEmpty()) {
			model.addObject("movies", moviesList);
		}
		return model;
	}
}
