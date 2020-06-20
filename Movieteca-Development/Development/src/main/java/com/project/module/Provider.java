package com.project.module;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int providerId;
	private int nrMoviesSold;
	private int nrMoviesRented;
	private int nrActivePosts;
	private float averageRating;
	private int nrOfReviews;
	private int nrRequestSent;
	@OneToMany(mappedBy = "provider")
	private Set<Request> requestsSent;
	@OneToMany(mappedBy = "provider")
	private Set<ProviderReview> receivedReviews;
	@OneToMany(mappedBy = "provider")
	private Set<Movie> moviesPosted;
	@ManyToOne
	@JoinColumn(name = "planId", nullable = false)
	private PaymentPlan paymentPlan;

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

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
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

	public void setNrActivePosts(int nrActivePosts) {
		this.nrActivePosts = nrActivePosts;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public int getNrOfReviews() {
		return nrOfReviews;
	}

	public void setNrOfReviews(int nrOfReviews) {
		this.nrOfReviews = nrOfReviews;
	}

	public int getNrRequestSent() {
		return nrRequestSent;
	}

	public void setNrRequestSent(int nrRequestSent) {
		this.nrRequestSent = nrRequestSent;
	}
}
