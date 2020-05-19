package com.project.movieteca;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.application.MovietecaApplication;
import com.project.module.Movie;
import com.project.repository.MovieRepository;
import com.project.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovietecaApplication.class })
class MovieServiceTests {
	@Autowired
	private MovieService movieService;

	@MockBean
	private MovieRepository movieRepository;
	private int globalId = 1;

	@BeforeEach
	public void setUp() {
		Movie movie = new Movie(globalId, "Movie1", 21, "Genre1", "Actors1", "Writers1", "Directors1", "1h", 0, 0,
				"Desc1", "Link1", "Today", 0, 0, 2.5, 0, null, null, 0, null, null, null, null, null);

		Movie movie2 = new Movie(2, "Movie2", 22, "Genre2", "Actors2", "Writers2", "Directors2", "2h", 0, 0, "Desc2",
				"Link2", "Today", 0, 0, 2.5, 0, null, null, 0, null, null, null, null, null);

		Movie movie3 = new Movie(3, "Movie3", 23, "Genre1", "Actors3", "Writers3", "Directors3", "3h", 0, 0, "Desc3",
				"Link3", "Today", 0, 0, 2.5, 0, null, null, 0, null, null, null, null, null);

		Movie movie4 = new Movie(4, "Movie4", 24, "Genre2", "Actors4", "Writers4", "Directors4", "4h", 0, 0, "Desc4",
				"Link4", "Today", 0, 0, 2.5, 0, null, null, 0, null, null, null, null, null);

		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		when(movieRepository.findAll()).thenReturn(movies);
		List<Movie> moviesByGenre = new ArrayList<Movie>();
		moviesByGenre.add(movie);
		moviesByGenre.add(movie3);
		when(movieRepository.findByGenre("Genre1")).thenReturn(moviesByGenre);
	}

	@Test
	public void getAllMovies_whenSizeIsCorrect_thenMoviesWereFound() {
		assertEquals(4, movieService.getAllMovies().size());
	}

	@Test
	public void getAllMoviesByGenre_whenMoviesAreFound_thenSizeIsCorrect() {
		String[] validGenre = { "Genre1" };

		assertEquals(2, movieService.getAllMoviesByGenre(validGenre).size());
	}
}
