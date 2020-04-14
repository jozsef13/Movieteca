package com.project.module;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float totalPrice;
	private String shippingDate;
	private Boolean status;
	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	private User user;
	@ManyToMany
	@JoinTable(name = "order_movie", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "movieId"))
	private Set<Movie> orederedMovies;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Movie> getOrederedMovies() {
		return orederedMovies;
	}

	public void setOrederedMovies(Set<Movie> orederedMovies) {
		this.orederedMovies = orederedMovies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
