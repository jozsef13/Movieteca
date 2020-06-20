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
@Table(name = "movie")

public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String postType;
	private int stock;
	private String genre;
	private String mainActors;
	private String witers;
	private String directors;
	private int playTime;
	private float rating;
	private float iMDbRating;
	private String description;
	private String trailerLink;
	private String releaseDate;
	private int nrOfReviews;
	private float averageRating;
	@ManyToOne
	@JoinColumn(name = "providerId", nullable = false)
	private Provider provider;
	@OneToMany(mappedBy = "movie")
	private Set<Review> reviewsReceived;

	public Set<Review> getReviewsReceived() {
		return reviewsReceived;
	}

	public void setReviewsReceived(Set<Review> reviewsReceived) {
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

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
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

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getiMDbRating() {
		return iMDbRating;
	}

	public void setiMDbRating(float iMDbRating) {
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

	public void setNrOfReviews(int nrOfReviews) {
		this.nrOfReviews = nrOfReviews;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
}
