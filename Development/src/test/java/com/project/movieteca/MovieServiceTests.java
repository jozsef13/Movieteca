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
import com.project.module.Provider;
import com.project.module.User;
import com.project.repository.MovieRepository;
import com.project.repository.ProviderRepository;
import com.project.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MovietecaApplication.class })
class MovieServiceTests {

	@Autowired
	private MovieService movieService;

	@MockBean
	private MovieRepository movieRepository;
	@MockBean
	private ProviderRepository providerRepository;

	@BeforeEach
	public void setUp() {
		Provider provider1 = new Provider(new User(1, "Provider1", "Popescu", "Maria", "provider1@email.com",
				"Provider", "F", "Provider12345", "12.01.1998", "Romania", "Dolj", "Craiova", "Str. Facultatii nr. 32",
				"0712345678", null, true, null), 0, 0, 0, 0, 0, 0, true, null, null, null, null, null);
		Provider provider2 = new Provider(new User(2, "Provider2", "Ion", "Cristian", "provider2@email.com", "Provider",
				"M", "Provider54321", "24.05.1994", "Romania", "Cluj", "Cluj-Napoca", "Str. Agronomiei nr. 56",
				"0787654321", null, true, null), 0, 0, 0, 0, 0, 0, true, null, null, null, null, null);

		Movie movie = new Movie(1, "Movie1", 21, "Genre1", "Actors1", "Writers1", "Directors1", "1h", 0, 0,
				"Desc1", "Link1", "Today", 0, 0, 2.5, 0, null, null, 0, null, provider2, null, null, null);

		Movie movie2 = new Movie(2, "Movie2", 22, "Genre2", "Actors2", "Writers2", "Directors2", "2h", 0, 0, "Desc2",
				"Link2", "Today", 0, 0, 2.5, 0, null, null, 0, null, provider1, null, null, null);

		Movie movie3 = new Movie(3, "Movie3", 23, "Genre1", "Actors3", "Writers3", "Directors3", "3h", 0, 0, "Desc3",
				"Link3", "Today", 0, 0, 2.5, 0, null, null, 0, null, provider2, null, null, null);

		Movie movie4 = new Movie(4, "Movie4", 24, "Genre2", "Actors4", "Writers4", "Directors4", "4h", 0, 0, "Desc4",
				"Link4", "Today", 0, 0, 2.5, 0, null, null, 0, null, provider1, null, null, null);
		
		List<Movie> moviesProvider1 = new ArrayList<Movie>();
		moviesProvider1.add(movie2);
		moviesProvider1.add(movie4);
		List<Movie> moviesProvider2 = new ArrayList<Movie>();
		moviesProvider2.add(movie);
		moviesProvider2.add(movie3);
		
		when(providerRepository.getOne(1)).thenReturn(provider1);
		when(providerRepository.getOne(2)).thenReturn(provider2);
		when(movieRepository.findByProvider(provider1)).thenReturn(moviesProvider1);
		when(movieRepository.findByProvider(provider2)).thenReturn(moviesProvider2);
	}
	
	@Test
	public void getAllMoviesByProvider_whenProviderIsCorrect_thenMoviesAreFound() {
		int providerId = 1;
		String providerName = "Provider1";
		
		for (Movie movie : movieService.getAllMoviesByProvider(providerId)) {
			assertEquals(providerName, movie.getProvider().getUserName());
		}
	}
}
