package com.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityNotFoundException;
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
	
	public Movie getMovieById(int movieId) {
		return movieRepo.findById(movieId).orElseThrow(() -> new EntityNotFoundException());
	}

	public List<Movie> getAllMoviesByGenre(String genre) {
		return movieRepo.findByGenre(genre);
	}

	public List<Movie> getMovieSortedByName(String sortTypeName) {
		List<Movie> movies = new ArrayList<Movie>(getAllMovies());

		if (sortTypeName.equals("aToZ")) {
			Collections.sort(movies, new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
		} else if (sortTypeName.equals("zToA")) {
			Collections.sort(movies, new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			Collections.reverse(movies);
		} else if (sortTypeName.equals("BuyPriceDescending")) {
			Collections.sort(movies, new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return Double.compare(o1.getBuyPrice(), o2.getBuyPrice());
				}
			});
			Collections.reverse(movies);
		} else if (sortTypeName.equals("BuyPriceAscending")) {
			Collections.sort(movies, new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return Double.compare(o1.getBuyPrice(), o2.getBuyPrice());
				}
			});
		} else if (sortTypeName.equals("RentPriceDescending")) {
			Collections.sort(movies, new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return Double.compare(o1.getRentPrice(), o2.getRentPrice());
				}
			});
			Collections.reverse(movies);
		} else if (sortTypeName.equals("RentPriceAscending")) {
			Collections.sort(movies, new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return Double.compare(o1.getRentPrice(), o2.getRentPrice());
				}
			});
		}
		
		return movies;
	}

	public List<Movie> getMoviesByPrice(double minD, double maxD) {
		List<Movie> movies = new ArrayList<Movie>(getAllMovies());
		List<Movie> sortedMovies = new ArrayList<Movie>();
		for (Movie movie : movies ) {
			if(movie.getBuyPrice() > minD && movie.getBuyPrice() < maxD) {
				sortedMovies.add(movie);
			}
		}
		return sortedMovies;
	}
}
