package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.MovieReview;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

}
