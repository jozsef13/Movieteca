package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	public Movie getMovieById(int movieId) {
		return movieRepo.findById(movieId).orElseThrow(() -> new EntityNotFoundException());
	}

	public List<Movie> getAllMoviesByGenre(String[] genreList) {
		List<Movie> foundMovies = new ArrayList<Movie>();

		for (String genre : genreList) {
			foundMovies.addAll(movieRepo.findByGenre(genre));
		}
		
		return foundMovies;
	}

	public List<Movie> getMovieSortedByName(String sortTypeName) {
		List<Movie> movies = new ArrayList<Movie>(getAllMovies());
		
		if (sortTypeName.equals("aToZ")) {
			movies = movieRepo.findAll(Sort.by("name").ascending());
		} else if (sortTypeName.equals("zToA")) {
			movies = movieRepo.findAll(Sort.by("name").descending());
		} else if (sortTypeName.equals("BuyPriceDescending")) {
			movies = movieRepo.findAll(Sort.by("buyPrice").descending());
		} else if (sortTypeName.equals("BuyPriceAscending")) {
			movies = movieRepo.findAll(Sort.by("buyPrice").ascending());
		} else if (sortTypeName.equals("RentPriceDescending")) {
			movies = movieRepo.findAll(Sort.by("rentPrice").descending());
		} else if (sortTypeName.equals("RentPriceAscending")) {
			movies = movieRepo.findAll(Sort.by("rentPrice").ascending());
		}

		return movies;
	}

	public List<Movie> getMoviesByPrice(double minD, double maxD, String priceType) {
		List<Movie> movies = new ArrayList<Movie>(getAllMovies());
		List<Movie> sortedMovies = new ArrayList<Movie>();
		
		for (Movie movie : movies) {
			if (priceType.equals("buyPrice")) {
				if (movie.getBuyPrice() > minD && movie.getBuyPrice() < maxD) {
					sortedMovies.add(movie);
				}
			}else if(priceType.equals("rentPrice")){
				if (movie.getRentPrice() > minD && movie.getRentPrice() < maxD) {
					sortedMovies.add(movie);
				}
			}
		}
		
		return sortedMovies;
	}

	public List<Movie> getMoviesByName(String nameString) {
		return movieRepo.findByName(nameString);
	}

	public List<Movie> getAllMoviesByPage(int page) {
		return movieRepo.findAll(PageRequest.of(page-1, 9)).getContent();
	}
}
