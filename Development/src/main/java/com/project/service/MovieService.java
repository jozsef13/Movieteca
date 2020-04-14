package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.module.Movie;
import com.project.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	public void addMovie(Movie movie) {
		movieRepo.save(movie);
	}
	
	public List<Movie> getAllMovies(){
		return movieRepo.findAll();
	}
}
