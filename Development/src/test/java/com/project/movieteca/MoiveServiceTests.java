package com.project.movieteca;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
class MoiveServiceTests {
	
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

        when(movieRepository.findById(globalId)).thenReturn(Optional.of(movie));
        when(movieRepository.findById(2)).thenReturn(Optional.of(movie2));
        when(movieRepository.findById(3)).thenReturn(Optional.of(movie3));
    }

    @Test
    public void getMovieById_whenValidId_thenMovieShouldBeFound() {
        int validId = 1;

        assertEquals(globalId, movieService.getMovieById(validId).getId());
    }

    @Test
    public void getMovieById_whenMovieDoesNotExist_thenThrowEntityNotFoundException() {
        int nonExistingId = 25;

        assertThrows(EntityNotFoundException.class, () -> {
            movieService.getMovieById(nonExistingId);
        });
    }

	
}
