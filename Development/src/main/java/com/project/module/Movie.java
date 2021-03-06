package com.project.module;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`movie`")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int stock;
	private String genre;
	private String mainActors;
	private String witers;
	private String directors;
	private String playTime;
	private double rating;
	private double iMDbRating;
	private String description;
	private String trailerLink;
	private String releaseDate;
	private int nrOfReviews;
	private double averageRating;
	private double buyPrice;
	private double rentPrice;
	private String imagePath;
	private String orderType;
	private int orderQuantity = 0;
	private String returningDate;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "providerId")
	private Provider provider;
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MovieReview> reviewsReceived;
	@ManyToMany(mappedBy = "moviesInCart")
	private Set<Cart> carts;
	@ManyToMany(mappedBy = "orederedMovies")
	private Set<Order> orders;
	
	public Movie(int id, String name, int stock, String genre, String mainActors, String witers, String directors,
			String playTime, double rating, double iMDbRating, String description, String trailerLink,
			String releaseDate, int nrOfReviews, double averageRating, double buyPrice, double rentPrice,
			String imagePath, String orderType, int orderQuantity, String returningDate, Provider provider,
			Set<MovieReview> reviewsReceived, Set<Cart> carts, Set<Order> orders) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.genre = genre;
		this.mainActors = mainActors;
		this.witers = witers;
		this.directors = directors;
		this.playTime = playTime;
		this.rating = rating;
		this.iMDbRating = iMDbRating;
		this.description = description;
		this.trailerLink = trailerLink;
		this.releaseDate = releaseDate;
		this.nrOfReviews = nrOfReviews;
		this.averageRating = averageRating;
		this.buyPrice = buyPrice;
		this.rentPrice = rentPrice;
		this.imagePath = imagePath;
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.returningDate = returningDate;
		this.provider = provider;
		this.reviewsReceived = new HashSet<MovieReview>();
		this.carts = new HashSet<Cart>();
		this.orders = new HashSet<Order>();
	}

	public Movie() {
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<MovieReview> getReviewsReceived() {
		return reviewsReceived;
	}

	public void setReviewsReceived(Set<MovieReview> reviewsReceived) {
		this.reviewsReceived = reviewsReceived;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMainActors() {
		return mainActors;
	}

	public void setMainActors(String mainActors) {
		this.mainActors = mainActors;
	}

	public String getWiters() {
		return witers;
	}

	public void setWiters(String witers) {
		this.witers = witers;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getiMDbRating() {
		return iMDbRating;
	}

	public void setiMDbRating(double iMDbRating) {
		this.iMDbRating = iMDbRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getNrOfReviews() {
		return nrOfReviews;
	}

	public void setNrOfReviews() {
		this.nrOfReviews = reviewsReceived.size();
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating() {
		double sum = 0;
		for (MovieReview movieReview : reviewsReceived) {
			sum += movieReview.getRating();
		}
		
		averageRating = sum/reviewsReceived.size();
	}
}
