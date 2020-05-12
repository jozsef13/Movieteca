package com.project.movieteca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.project.module.Movie;
import com.project.module.PlanType;
import com.project.module.Provider;
import com.project.module.Request;
import com.project.module.RequestStatus;
import com.project.module.User;


class MovietecaApplicationTests {

	@Test
	void getMoviePostedById() {
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
        
        
        Provider provider = new Provider(0, 0, movies.size(), 0, 0, 0, null, null, movies, null, null, new User(1, "User1", "User1_2", "User1_3", "user@email.com", "Provider", "M", "Test123", "12.01.1998", "Romania", "Dolj", "Craiova", "Str. Trandafirului", "0746969696", null, true, null));
	
        Movie movie = provider.getMoviePostedById(5);
        Assert.isTrue(movie == fifthMovie);
	}
	
	@Test
	void getRequestsByStatus() {
		
		Set<Request> requests =  new HashSet<Request>();
        Request fisrtRequest = new Request(1, "add movie", RequestStatus.Approved, "text1", null, null);
        Request secondRequest = new Request(2, "update movie", RequestStatus.Approved, "text2", null, null);
        Request thirdRequest = new Request(3, "add movie3", RequestStatus.Sent, "text3", null, null);
        Request fourthRequest = new Request(4, "add movie2", RequestStatus.Sent, "text4", null, null);
        Request fifthRequest = new Request(5, "add movie69", RequestStatus.Denied, "text5", null, null);
        Request sixthRequest = new Request(6, "add movie20", RequestStatus.Sent, "text6", null, null);

        requests.add(fisrtRequest);
        requests.add(secondRequest);
        requests.add(thirdRequest);
        requests.add(fourthRequest);
        requests.add(fifthRequest);
        requests.add(sixthRequest);
        
        Provider provider = new Provider(0, 0, 0, 0, 0, requests.size(), requests, null, null, null, null, new User(1, "User1", "User1_2", "User1_3", "user@email.com", "Provider", "M", "Test123", "12.01.1998", "Romania", "Dolj", "Craiova", "Str. Trandafirului", "0746969696", null, true, null));

        List<Request> returned = provider.getRequestsByStatus(RequestStatus.Sent);
        Assert.isTrue(!returned.isEmpty());
        
        
	}

}
