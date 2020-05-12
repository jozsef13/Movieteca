package com.project.module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double totalPrice;
	private String shippingDate = dateTime();
	private OrderStatus status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId", nullable = true)
	private Customer customer;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "moviesFromOrder", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "movieId"))
	private Set<Movie> orederedMovies = new LinkedHashSet<Movie>();

	public Order(int id, double totalPrice, String shippingDate, OrderStatus status, Customer customer,
			Set<Movie> orederedMovies) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.shippingDate = shippingDate;
		this.status = status;
		this.customer = customer;
		this.orederedMovies = orederedMovies;
	}
    public Order() {
    	
    }
	public Movie getMovieFromOrderById(int Id) {
		Movie returningMovie = new Movie();
		for (Movie movie : orederedMovies) {
			if(movie.getId()==Id) {
				returningMovie=movie;
				break;
			}
		}
		return returningMovie;
	}
	
	public List<Movie> getMoviesFromOrderByOrderType(String type){
		List<Movie> returningMovies = new ArrayList<Movie>();
		for (Movie movie : orederedMovies) {
			if(movie.getOrderType().equals(type)) {
				returningMovies.add(movie);
			}
		}
		return returningMovies;
	}
	
	private String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate local = LocalDate.now();
		LocalDate shipDay = local.plusDays(3);
		return dtf.format(shipDay);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
