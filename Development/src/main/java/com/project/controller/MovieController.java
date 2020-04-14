package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Movie;
import com.project.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/addMovie")
	public ModelAndView addMovie(Movie movie) {
		ModelAndView model = new ModelAndView("singlemovie");
		movieService.addMovie(movie);
		model.addObject(movie);
		return model;
	}

	@GetMapping("/movies")
	public ModelAndView getAllMovies() {
		ModelAndView model = new ModelAndView("movies");
		List<Movie> movies = new ArrayList<Movie>(movieService.getAllMovies());
		model.addObject("movies", movies);
		return model;
	}
}
