package com.project.module;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`movieReview`")
public class MovieReview extends Review {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieReviewId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movieId", nullable = false)
	private Movie movie;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getMovieReviewId() {
		return movieReviewId;
	}

	public void setMovieReviewId(int movieReviewId) {
		this.movieReviewId = movieReviewId;
	}
}
