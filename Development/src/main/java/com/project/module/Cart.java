package com.project.module;

<<<<<<< Updated upstream
import java.util.LinkedHashSet;
=======
import java.util.HashSet;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	private Set<Movie> moviesInCart = new LinkedHashSet<Movie>();
=======
	private Set<Movie> moviesInCart = new HashSet<Movie>();
>>>>>>> Stashed changes

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
