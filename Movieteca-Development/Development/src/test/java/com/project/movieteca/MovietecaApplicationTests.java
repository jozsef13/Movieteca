package com.project.movieteca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.project.module.Movie;
import com.project.module.Order;
import com.project.module.OrderStatus;


class MovietecaApplicationTests {

	@Test
	void getMovieFromOrderById() {
		Set<Movie> movies = new HashSet<Movie>();
        Movie firstMovie = new Movie(1, "Movie1", 20, "Genre1", "Actors1", "Writers1", "Directors1", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 2.5, 0, null, null, 0, null, null, null, null, null);
        Movie secondMovie = new Movie(2, "Movie2", 20, "Genre2", "Actors2", "Writers2", "Directors2", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5, 0, null, null, 0, null, null, null, null, null);
        Movie thirdMovie = new Movie(3, "Movie3", 20, "Genre3", "Actors3", "Writers3", "Directors3", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 10, 0, null, null, 0, null, null, null, null, null);
        Movie fourthMovie = new Movie(4, "Movie4", 20, "Genre4", "Actors4", "Writers4", "Directors4", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 7, 0, null, null, 0, null, null, null, null, null);
        Movie fifthMovie = new Movie(5, "Movie5", 20, "Genre5", "Actors5", "Writers5", "Directors5", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5.99, 0, null, null, 0, null, null, null, null, null);
        Movie sixthMovie = new Movie(6, "Movie6", 20, "Genre6", "Actors6", "Writers6", "Directors6", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 6.75, 0, null, null, 0, null, null, null, null, null);
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);
        movies.add(fourthMovie);
        movies.add(fifthMovie);
        movies.add(sixthMovie);
        Order order = new Order(1, 0, "Today", OrderStatus.Placed, null, movies);
        Movie movie = order.getMovieFromOrderById(4);
        Assert.isTrue(movie == fourthMovie);
	}
	@Test
	void getMoviesFromOrderByOrderType() {
		Set<Movie> movies = new HashSet<Movie>();
		Movie firstMovie = new Movie(1, "Movie1", 20, "Genre1", "Actors1", "Writers1", "Directors1", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 2.5, 0, null, "Buy", 0, null, null, null, null, null);
        Movie secondMovie = new Movie(2, "Movie2", 20, "Genre2", "Actors2", "Writers2", "Directors2", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5, 0, null, "Rent", 0, null, null, null, null, null);
        Movie thirdMovie = new Movie(3, "Movie3", 20, "Genre3", "Actors3", "Writers3", "Directors3", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 10, 0, null, "Buy", 0, null, null, null, null, null);
        Movie fourthMovie = new Movie(4, "Movie4", 20, "Genre4", "Actors4", "Writers4", "Directors4", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 7, 0, null, "Rent", 0, null, null, null, null, null);
        Movie fifthMovie = new Movie(5, "Movie5", 20, "Genre5", "Actors5", "Writers5", "Directors5", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5.99, 0, null, "Rent", 0, null, null, null, null, null);
        Movie sixthMovie = new Movie(6, "Movie6", 20, "Genre6", "Actors6", "Writers6", "Directors6", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 6.75, 0, null, "Rent", 0, null, null, null, null, null);
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);
        movies.add(fourthMovie);
        movies.add(fifthMovie);
        movies.add(sixthMovie);
        Order order = new Order(1, 0, "Today", OrderStatus.Placed, null, movies);
        List<Movie> moviesReturned = order.getMoviesFromOrderByOrderType("Buy");

        Assert.isTrue(!moviesReturned.isEmpty());
	}

}
