package com.project.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.module.Movie;
import com.project.repository.MovieRepository;

public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

	public Movie getMovieById(int movieId) {
		return movieRepo.findById(movieId).orElseThrow(() -> new EntityNotFoundException());
	}
}
