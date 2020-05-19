package com.project.module;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`customer`")
public class Customer extends User {

	private int nrMoviesBought = 0;
	private int nrMoviesRented = 0;
	private int nrMoviesInCart = 0;
	private int nrOfReviewsAdded = 0;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ProviderReview> providerReviewsAdded;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<MovieReview> movieReviewsAdded;
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Order> orders;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Message> messages;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Request> requestsSent;

	public Customer(User user, int nrMoviesBought, int nrMoviesRented, int nrMoviesInCart, int nrOfReviewsAdded,
			Set<ProviderReview> providerReviewsAdded, Set<MovieReview> movieReviewsAdded, Cart cart, Set<Order> orders,
			Set<Message> messages, Set<Request> requestsSent) {
		super(user);
		this.nrMoviesBought = nrMoviesBought;
		this.nrMoviesRented = nrMoviesRented;
		this.nrMoviesInCart = nrMoviesInCart;
		this.nrOfReviewsAdded = nrOfReviewsAdded;
		this.providerReviewsAdded = providerReviewsAdded;
		this.movieReviewsAdded = movieReviewsAdded;
		this.cart = cart;
		this.orders = orders;
		this.messages = messages;
		this.requestsSent = requestsSent;
	}

	public Customer() {

	}

	public Set<Request> getRequestsSent() {
		return requestsSent;
	}

	public void setRequestsSent(Set<Request> requestsSent) {
		this.requestsSent = requestsSent;
	}

	public Set<ProviderReview> getProviderReviewsAdded() {
		return providerReviewsAdded;
	}

	public void setProviderReviewsAdded(Set<ProviderReview> providerReviewsAdded) {
		this.providerReviewsAdded = providerReviewsAdded;
	}

	public Set<MovieReview> getMovieReviewsAdded() {
		return movieReviewsAdded;
	}

	public void setMovieReviewsAdded(Set<MovieReview> movieReviewsAdded) {
		this.movieReviewsAdded = movieReviewsAdded;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> newMessages) {
		this.messages = newMessages;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public int getNrMoviesBought() {
		return nrMoviesBought;
	}

	public void setNrMoviesBought() {
		for (Order order : orders) {
			for (Movie movie : order.getOrederedMovies()) {
				if (movie.getOrderType().equals("Buy")) {
					this.nrMoviesBought++;
				}
			}
		}
	}

	public int getNrMoviesRented() {
		return nrMoviesRented;
	}

	public void setNrMoviesRented() {
		for (Order order : orders) {
			for (Movie movie : order.getOrederedMovies()) {
				if (movie.getOrderType().equals("Rent")) {
					this.nrMoviesRented++;
				}
			}
		}
	}

	public int getNrMoviesInCart() {
		return nrMoviesInCart;
	}

	public void setNrMoviesInCart() {
		this.nrMoviesInCart = cart.getMoviesInCart().size();
	}

	public int getNrOfReviewsAdded() {
		return nrOfReviewsAdded;
	}

	public void setNrOfReviewsAdded() {
		this.nrOfReviewsAdded = providerReviewsAdded.size() + movieReviewsAdded.size();
	}
}
