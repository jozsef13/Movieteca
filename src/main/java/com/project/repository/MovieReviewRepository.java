package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.MovieReview;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

}
