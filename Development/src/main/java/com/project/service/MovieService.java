package com.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.module.Movie;
import com.project.module.Provider;
import com.project.repository.MovieRepository;
import com.project.repository.ProviderRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private ProviderRepository providerRepository;

	public void addMovie(Movie movie, MultipartFile img, Provider provider) throws IOException {
		String imgFile = "/images/" + img.getOriginalFilename();
		File upl = new File("src/main/resources/static" + imgFile);
		upl.createNewFile();
		FileOutputStream fout = new FileOutputStream(upl);
		fout.write(img.getBytes());
		fout.close();
		movie.setImagePath(imgFile);
		movie.setProvider(provider);
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

	public List<Movie> getMovieSortedByName(String sortTypeName, int currentPage) {
		List<Movie> movies = new ArrayList<Movie>(getAllMovies());
		if (sortTypeName.equals("aToZ")) {
			movies = movieRepo.findAll(PageRequest.of(currentPage - 1, 6, Sort.by("name").ascending())).getContent();
		} else if (sortTypeName.equals("zToA")) {
			movies = movieRepo.findAll(PageRequest.of(currentPage - 1, 6, Sort.by("name").descending())).getContent();
		} else if (sortTypeName.equals("BuyPriceDescending")) {
			movies = movieRepo.findAll(PageRequest.of(currentPage - 1, 6, Sort.by("buyPrice").descending()))
					.getContent();
		} else if (sortTypeName.equals("BuyPriceAscending")) {
			movies = movieRepo.findAll(PageRequest.of(currentPage - 1, 6, Sort.by("buyPrice").ascending()))
					.getContent();
		} else if (sortTypeName.equals("RentPriceDescending")) {
			movies = movieRepo.findAll(PageRequest.of(currentPage - 1, 6, Sort.by("rentPrice").descending()))
					.getContent();
		} else if (sortTypeName.equals("RentPriceAscending")) {
			movies = movieRepo.findAll(PageRequest.of(currentPage - 1, 6, Sort.by("rentPrice").ascending()))
					.getContent();
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
			} else if (priceType.equals("rentPrice")) {
				if (movie.getRentPrice() > minD && movie.getRentPrice() < maxD) {
					sortedMovies.add(movie);
				}
			}
		}

		return sortedMovies;
	}

	public List<Movie> getMoviesByName(String nameString, int currentPage) {
		return movieRepo.findByName(nameString, PageRequest.of(currentPage - 1, 6));
	}

	public List<Movie> getAllMoviesByPage(int page) {
		return movieRepo.findAll(PageRequest.of(page - 1, 6, Sort.by("stock").descending())).getContent();
	}

	public List<Movie> getAllMoviesById() {
		List<Movie> sortedMovies = movieRepo.findAll(Sort.by("id").descending());
		if (sortedMovies.size() > 6) {
			return sortedMovies.subList(0, 6);
		}

		return sortedMovies;
	}

	public int getNumberOfPages() {
		int noOfPages = 1;
		List<Movie> movies = movieRepo.findAll();
		int i = 1;
		boolean valid = true;
		while (valid) {
			if (movies.size() + 1 > i * 6) {
				noOfPages++;
			} else {
				valid = false;
			}
			i++;
		}
		return noOfPages;
	}

	public long getNumberOfMovies() {
		return movieRepo.count();
	}

	public int getNumberOfSearchedPages(String name) {
		List<Movie> movies = movieRepo.findByName(name);
		int noOfPages = 1;
		int i = 1;
		boolean valid = true;
		while (valid) {
			if (movies.size() + 1 > i * 6) {
				noOfPages++;
			} else {
				valid = false;
			}
			i++;
		}
		return noOfPages;
	}

	public List<Movie> getAllMoviesByProvider(int id) {
		Provider provider = providerRepository.getOne(id);
		return movieRepo.findByProvider(provider);
	}

	public Movie updateMovie(Movie movie, double buyPrice, double rentPrice, int stock) {
		movie.setBuyPrice(buyPrice);
		movie.setRentPrice(rentPrice);
		movie.setStock(stock);
		return movieRepo.save(movie);
	}
}
