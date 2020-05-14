package com.project.module;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(columnDefinition = "bit default 0")
	private boolean permission;
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Request> requestsSent;
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ProviderReview> receivedReviews;
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Movie> moviesPosted;
	@ManyToOne
	@JoinColumn(name = "planId", nullable = false)
	private PaymentPlan paymentPlan;
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true)
	private Set<Message> messages;

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
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
