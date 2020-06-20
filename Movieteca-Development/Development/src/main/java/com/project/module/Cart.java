package com.project.module;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")

public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float totalPrice;
	@OneToOne
	private Customer customer;
	@ManyToMany
	@JoinTable(name = "movies_cart", joinColumns = @JoinColumn(name = "cartId"), inverseJoinColumns = @JoinColumn(name = "movieId"))
	private Set<Movie> moviesInCart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalPrice() {
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

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
