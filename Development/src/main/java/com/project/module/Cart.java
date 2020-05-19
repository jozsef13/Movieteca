package com.project.module;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`cart`")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double totalPrice;
	@OneToOne
	private Customer customer;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "moviesFromCart", joinColumns = @JoinColumn(name = "cartId"), inverseJoinColumns = @JoinColumn(name = "movieId"))
	private Set<Movie> moviesInCart = new HashSet<Movie>();

	public Cart(int id, double totalPrice, Customer customer, Set<Movie> moviesInCart) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.moviesInCart = moviesInCart;
	}

	public Cart() {
	}

	public Movie getMovieFromCartById(int id) {
		Movie returnMovie = new Movie();
		for (Movie movie : moviesInCart) {
			if (movie.getId() == id) {
				returnMovie = movie;
				break;
			}
		}
		return returnMovie;
	}

	public List<Movie> getMoviesWithBuyPriceGraterThan(double buyPrice) {
		List<Movie> returningMovies = new ArrayList<Movie>();

		for (Movie movie : moviesInCart) {
			if (movie.getBuyPrice() > buyPrice) {
				returningMovies.add(movie);
			}
		}

		return returningMovies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Movie> getMoviesInCart() {
		return moviesInCart;
	}

	public void setMoviesInCart(Set<Movie> moviesInCart) {
		this.moviesInCart = moviesInCart;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
