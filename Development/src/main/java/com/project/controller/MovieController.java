package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Movie;
import com.project.service.MovieService;

public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/movie/{id}")
	public ModelAndView getMovieById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("singlemovie");
		Movie movie = movieService.getMovieById(id);
		model.addObject(movie);
		return model;
	}
}
