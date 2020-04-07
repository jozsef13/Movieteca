package com.project.module;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int nrMoviesBought;
	private int nrMoviesRented;
	private int nrMoviesInCart;
	private int nrOfReviewsAdded;
	@OneToMany(mappedBy = "customer")
	private Set<Review> reviewsAdded;
	@OneToOne
	private Cart cart;
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;

	public int getId() {
		return id;
	}

	public Set<Review> getReviewsAdded() {
		return reviewsAdded;
	}

	public void setReviewsAdded(Set<Review> reviewsAdded) {
		this.reviewsAdded = reviewsAdded;
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

	public void setId(int id) {
		this.id = id;
	}

	public int getNrMoviesBought() {
		return nrMoviesBought;
	}

	public void setNrMoviesBought(int nrMoviesBought) {
		this.nrMoviesBought = nrMoviesBought;
	}

	public int getNrMoviesRented() {
		return nrMoviesRented;
	}

	public void setNrMoviesRented(int nrMoviesRented) {
		this.nrMoviesRented = nrMoviesRented;
	}

	public int getNrMoviesInCart() {
		return nrMoviesInCart;
	}

	public void setNrMoviesInCart(int nrMoviesInCart) {
		this.nrMoviesInCart = nrMoviesInCart;
	}

	public int getNrOfReviewsAdded() {
		return nrOfReviewsAdded;
	}

	public void setNrOfReviewsAdded(int nrOfReviewsAdded) {
		this.nrOfReviewsAdded = nrOfReviewsAdded;
	}
}
