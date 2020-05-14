package com.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Movie;
import com.project.module.MyUserDetails;
import com.project.module.Provider;
import com.project.service.MovieService;
import com.project.service.UserService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;

	@PostMapping("/addMovie")
	public ModelAndView addMovie(Movie movie, @RequestPart MultipartFile img, HttpServletRequest request) throws IOException {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Provider provider = new Provider();
		if(userDetails.getUser().getUserType().equals("Provider")) {
			provider = (Provider) userDetails.getUser();
		} else if(userDetails.getUser().getUserType().equals("Admin")) {
			provider = userService.getProviderById(2);
		}
		
		ModelAndView model = new ModelAndView("singlemovie");
		movieService.addMovie(movie, img, provider);
		model.addObject(movie);
		return model;
	}

	@GetMapping("/movies")
	public ModelAndView getAllMovies(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortType) {
		ModelAndView model = new ModelAndView("movies");
		long numberOfMovies = movieService.getNumberOfMovies();
		int currentPage = page.orElse(1);
		String sortTypeString = sortType.orElse(null);
		if (sortTypeString != null) {
			return getMovieSortedByName(sortTypeString, currentPage);
		} else {
			List<Movie> movies = new ArrayList<Movie>(movieService.getAllMoviesByPage(currentPage));
			int noOfPages = movieService.getNumberOfPages();

			model.addObject("numberOfMovies", numberOfMovies).addObject("movies", movies)
					.addObject("currentPage", currentPage).addObject("noOfPages", noOfPages);

			return model;
		}
	}

	@GetMapping("/movie/{id}")
	public ModelAndView getMovieById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("singlemovie");
		Movie movie = movieService.getMovieById(id);

		model.addObject(movie);

		return model;
	}

	@GetMapping("/movies/byPrice")
	public ModelAndView getMoviesByPrice(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("movies");
		String priceType = request.getParameter("priceType");
		String min = request.getParameter("minPrice");
		String max = request.getParameter("maxPrice");
		double minD = Double.parseDouble(min);
		double maxD = Double.parseDouble(max);
		long numberOfMovies = movieService.getNumberOfMovies();

		List<Movie> sortedMovies = movieService.getMoviesByPrice(minD, maxD, priceType);

		model.addObject("numberOfMovies", numberOfMovies).addObject("movies", sortedMovies);

		return model;
	}

	@GetMapping("/movies/genre")
	public ModelAndView getMoviesByGenre(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("movies");
		String[] genre = request.getParameterValues("genre");
		if (genre == null) {
			String error = "You must select a genre!";
			List<Movie> movies = new ArrayList<Movie>(movieService.getAllMoviesByPage(1));
			int noOfPages = movieService.getNumberOfPages();
			long numberOfMovies = movieService.getNumberOfMovies();
			model.addObject("numberOfMovies", numberOfMovies).addObject("movies", movies).addObject("currentPage", 1)
					.addObject("noOfPages", noOfPages).addObject("errorMessage", error);
			return model;
		}
		List<Movie> movies = movieService.getAllMoviesByGenre(genre);
		long numberOfMovies = movieService.getNumberOfMovies();

		model.addObject("numberOfMovies", numberOfMovies).addObject("movies", movies);

		return model;
	}

	public ModelAndView getMovieSortedByName(String sortTypeName, int currentPage) {
		ModelAndView model = new ModelAndView("movies");
		List<Movie> movies = movieService.getMovieSortedByName(sortTypeName, currentPage);
		long numberOfMovies = movieService.getNumberOfMovies();
		int noOfPages = movieService.getNumberOfPages();

		model.addObject("numberOfMovies", numberOfMovies).addObject("movies", movies)
				.addObject("currentPage", currentPage).addObject("noOfPages", noOfPages)
				.addObject("sortTypeName", sortTypeName);

		return model;
	}

	@GetMapping("/movies/search")
	public ModelAndView getMoviesByName(@RequestParam String nameString, @RequestParam Optional<Integer> page) {
		ModelAndView model = new ModelAndView("searchedMovies");
		int currentPage = page.orElse(1);
		List<Movie> movies = movieService.getMoviesByName(nameString, currentPage);
		long numberOfMovies = movieService.getNumberOfMovies();
		int noOfPages = movieService.getNumberOfSearchedPages(nameString);

		model.addObject("numberOfMovies", numberOfMovies).addObject("movies", movies)
				.addObject("currentPage", currentPage).addObject("noOfPages", noOfPages)
				.addObject("searchString", nameString);

		return model;
	}

	@GetMapping("/movies/provider/{id}")
	public ModelAndView getAllMoviesByProvider(@PathVariable int id) {
		ModelAndView model = new ModelAndView("editmovielist");
		List<Movie> movies = new ArrayList<Movie>(movieService.getAllMoviesByProvider(id));

		model.addObject("movies", movies).addObject("numberOfMovies", movies.size());

		return model;
	}
	
	@GetMapping("/movies/edit")
	public ModelAndView getAllMoviesToEdit() {
		ModelAndView model = new ModelAndView("editmovielist");
		List<Movie> movies = new ArrayList<Movie>(movieService.getAllMovies());

		model.addObject("movies", movies).addObject("numberOfMovies", movies.size());

		return model;
	}
	
	@RequestMapping(value="/movie/editPage/{id}")
	public ModelAndView editMoviePage(@PathVariable int id) {
		ModelAndView model = new ModelAndView("editmovie");
		Movie movie = movieService.getMovieById(id);
		model.addObject("movie", movie);
		return model;
	}
	
	@RequestMapping(value="/movie/edit/{id}")
	public ModelAndView editMovieById(@PathVariable int id, @RequestParam double buyPrice, @RequestParam double rentPrice, @RequestParam int stock) throws IOException {
		ModelAndView model = new ModelAndView("singlemovie");
		Movie movie = movieService.getMovieById(id);
		Movie updatedMovie = movieService.updateMovie(movie, buyPrice, rentPrice, stock);
		String message = "Successfuly updated movie!";
		model.addObject("message", message );
		model.addObject("movie", updatedMovie);
		return model;
	}
	
	@RequestMapping(value = "/addMoviePage")
	public ModelAndView addMoviePage() {
		return new ModelAndView("editmovie");
	}
}
