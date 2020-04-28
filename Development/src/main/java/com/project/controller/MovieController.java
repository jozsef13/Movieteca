package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.application.MovietecaApplication;
import com.project.module.Cart;
import com.project.module.Movie;
import com.project.service.CartService;
import com.project.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private CartController cartController;
	@Autowired
	private CartService cartService;

	@PostMapping("/addMovie")
	public ModelAndView addMovie(Movie movie) {
		ModelAndView model = new ModelAndView("singlemovie");
		movieService.addMovie(movie);
		model.addObject(movie);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if (cart != null) {
			model.addObject(cart);
		}
		return model;
	}

	@GetMapping("/movies")
	public ModelAndView getAllMovies() {
		ModelAndView model = new ModelAndView("movies");
		List<Movie> movies = new ArrayList<Movie>(movieService.getAllMovies());
		model.addObject("movies", movies);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if (cart != null) {
			model.addObject(cart);
		}
		return model;
	}

	@GetMapping("/movies/{sortTypeName}")
	public ModelAndView getMovieSortedByName(@PathVariable String sortTypeName) {
		ModelAndView model = new ModelAndView("movies");
		List<Movie> movies = movieService.getMovieSortedByName(sortTypeName);
		model.addObject("movies", movies);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if (cart != null) {
			model.addObject(cart);
		}

		return model;
	}

	@GetMapping("/movie/{id}")
	public ModelAndView getMovieById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("singlemovie");
		Movie movie = movieService.getMovieById(id);
		model.addObject(movie);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if (cart != null) {
			model.addObject(cart);
		}
		return model;
	}

	@GetMapping("/addToCart/Movie/{id}")
	public ModelAndView addMovieToCart(@PathVariable int id, HttpServletRequest request) {
		String type = request.getParameter("orderType");
		Movie movie = movieService.getMovieById(id);
		ModelAndView model = cartController.addMovieToCart(movie, type);
		return model;
	}
	
	@GetMapping("/movies/byPrice")
	public ModelAndView getMoviesByPrice(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("movies");
		String min = request.getParameter("minPrice");
		String max = request.getParameter("maxPrice");
		double minD = Double.parseDouble(min);
		double maxD = Double.parseDouble(max);
		List<Movie> sortedMovies = movieService.getMoviesByPrice(minD, maxD);
		model.addObject("movies", sortedMovies);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if (cart != null) {
			model.addObject(cart);
		}
		return model ;
	}
	
	@GetMapping("/movies/genre")
	public ModelAndView getMoviesByGenre(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("movies");
		String genre = request.getParameter("genre");
		List<Movie> movies = movieService.getAllMoviesByGenre(genre);
		model.addObject("movies", movies);
		Cart cart = cartService.getCartById(MovietecaApplication.cartId);
		if (cart != null) {
			model.addObject(cart);
		}
		return model;
	}
}
