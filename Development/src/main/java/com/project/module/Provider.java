package com.project.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`provider`")
public class Provider extends User {

	private int nrMoviesSold = 0;
	private int nrMoviesRented = 0;
	private int nrActivePosts = 0;
	private double averageRating = 0;
	private int nrOfReviews = 0;
	private int nrRequestSent = 0;
	@OneToMany(mappedBy = "provider")
	private Set<Request> requestsSent;
	@OneToMany(mappedBy = "provider")
	private Set<ProviderReview> receivedReviews;
	@OneToMany(mappedBy = "provider")
	private Set<Movie> moviesPosted;
	@ManyToOne
	@JoinColumn(name = "planId", nullable = false)
	private PaymentPlan paymentPlan;
	@OneToMany(mappedBy = "provider")
	private Set<Message> messages;

	
	
	public Provider(int nrMoviesSold, int nrMoviesRented, int nrActivePosts, double averageRating, int nrOfReviews,
			int nrRequestSent, Set<Request> requestsSent, Set<ProviderReview> receivedReviews, Set<Movie> moviesPosted,
			PaymentPlan paymentPlan, Set<Message> messages, User user) {
		super(user);
		this.nrMoviesSold = nrMoviesSold;
		this.nrMoviesRented = nrMoviesRented;
		this.nrActivePosts = nrActivePosts;
		this.averageRating = averageRating;
		this.nrOfReviews = nrOfReviews;
		this.nrRequestSent = nrRequestSent;
		this.requestsSent = requestsSent;
		this.receivedReviews = receivedReviews;
		this.moviesPosted = moviesPosted;
		this.paymentPlan = paymentPlan;
		this.messages = messages;
	}
	
	public Movie getMoviePostedById(int id) {
        Movie returnMovie = new Movie();

        for (Movie movie : moviesPosted) {
            if(movie.getId() == id) {
                returnMovie = movie;
                break;
            }
        }

        return returnMovie;
    }

    public List<Request> getRequestsByStatus(RequestStatus status){
        List<Request> returnRequests = new ArrayList<Request>();
        for (Request request : requestsSent) {
            if(request.getStatus().equals(status)) {
                returnRequests.add(request);
            }
        }

        return returnRequests;
    }

	public Set<ProviderReview> getReceivedReviews() {
		return receivedReviews;
	}

	public PaymentPlan getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(PaymentPlan paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public void setReceivedReviews(Set<ProviderReview> receivedReviews) {
		this.receivedReviews = receivedReviews;
	}

	public Set<Movie> getMoviesPosted() {
		return moviesPosted;
	}

	public void setMoviesPosted(Set<Movie> moviesPosted) {
		this.moviesPosted = moviesPosted;
	}

	public Set<Request> getRequestsSent() {
		return requestsSent;
	}

	public void setRequestsSent(Set<Request> requestsSent) {
		this.requestsSent = requestsSent;
	}

	public int getNrMoviesSold() {
		return nrMoviesSold;
	}

	public void setNrMoviesSold(int nrMoviesSold) {
		this.nrMoviesSold = nrMoviesSold;
	}

	public int getNrMoviesRented() {
		return nrMoviesRented;
	}

	public void setNrMoviesRented(int nrMoviesRented) {
		this.nrMoviesRented = nrMoviesRented;
	}

	public int getNrActivePosts() {
		return nrActivePosts;
	}

	public void setNrActivePosts() {
		for (Movie movie : moviesPosted) {
			if(movie.getStock() > 0) {
				nrActivePosts++;
			}
		}
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating() {
		double sum = 0;
		for (ProviderReview review : receivedReviews) {
			sum  += review.getRating();
		}
		this.averageRating = sum/receivedReviews.size();
	}

	public int getNrOfReviews() {
		return nrOfReviews;
	}

	public void setNrOfReviews() {
		this.nrOfReviews = receivedReviews.size();
	}

	public int getNrRequestSent() {
		return nrRequestSent;
	}

	public void setNrRequestSent() {
		this.nrRequestSent = requestsSent.size();
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}
