package com.project.movieteca;

class MovietecaApplicationTests {

//	@Test
//	void getMoviesFromCartById() {
//		Set<Movie> movies = new HashSet<Movie>();
//		Movie firstMovie = new Movie(1, "Movie1", 20, "Genre1", "Actors1", "Writers1", "Directors1", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 2.5, 0, null, "Buy", 0, null, null, null, null, null);
//		Movie secondMovie = new Movie(2, "Movie2", 20, "Genre2", "Actors2", "Writers2", "Directors2", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5, 0, null, "Rent", 0, null, null, null, null, null);
//		Movie thirdMovie = new Movie(3, "Movie3", 20, "Genre3", "Actors3", "Writers3", "Directors3", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 10, 0, null, "Buy", 0, null, null, null, null, null);
//		Movie fourthMovie = new Movie(4, "Movie4", 20, "Genre4", "Actors4", "Writers4", "Directors4", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 7, 0, null, "Rent", 0, null, null, null, null, null);
//		Movie fifthMovie = new Movie(5, "Movie5", 20, "Genre5", "Actors5", "Writers5", "Directors5", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5.99, 0, null, "Rent", 0, null, null, null, null, null);
//		Movie sixthMovie = new Movie(6, "Movie6", 20, "Genre6", "Actors6", "Writers6", "Directors6", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 6.75, 0, null, "Rent", 0, null, null, null, null, null);
//		movies.add(firstMovie);
//		movies.add(secondMovie);
//		movies.add(thirdMovie);
//		movies.add(fourthMovie);
//		movies.add(fifthMovie);
//		movies.add(sixthMovie);
//		Cart cart = new Cart(1, 0, null, movies);
//		
//		Movie movie = cart.getMovieFromCartById(3);
//		assertEquals(thirdMovie.getId(), movie.getId()); 
//	}
//	
//	@Test
//	void getMoviesWithBuyPriceGraterThan() {
//		Set<Movie> movies = new HashSet<Movie>();
//		Movie firstMovie = new Movie(1, "Movie1", 20, "Genre1", "Actors1", "Writers1", "Directors1", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 2.5, 0, null, null, 0, null, null, null, null, null);
//		Movie secondMovie = new Movie(2, "Movie2", 20, "Genre2", "Actors2", "Writers2", "Directors2", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5, 0, null, null, 0, null, null, null, null, null);
//		Movie thirdMovie = new Movie(3, "Movie3", 20, "Genre3", "Actors3", "Writers3", "Directors3", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 10, 0, null, null, 0, null, null, null, null, null);
//		Movie fourthMovie = new Movie(4, "Movie4", 20, "Genre4", "Actors4", "Writers4", "Directors4", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 7, 0, null, null, 0, null, null, null, null, null);
//		Movie fifthMovie = new Movie(5, "Movie5", 20, "Genre5", "Actors5", "Writers5", "Directors5", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 5.99, 0, null, null, 0, null, null, null, null, null);
//		Movie sixthMovie = new Movie(6, "Movie6", 20, "Genre6", "Actors6", "Writers6", "Directors6", "2h", 0, 0, "Desc", "Link", "Today", 0, 0, 6.75, 0, null, null, 0, null, null, null, null, null);
//		movies.add(firstMovie);
//		movies.add(secondMovie);
//		movies.add(thirdMovie);
//		movies.add(fourthMovie);
//		movies.add(fifthMovie);
//		movies.add(sixthMovie);
//		Cart cart = new Cart(1, 0, null, movies);
//		List<Movie> moviesReturned = cart.getMoviesWithBuyPriceGraterThan(6);
//		
//		assertEquals(!moviesReturned.isEmpty(), true);
//	}
}
