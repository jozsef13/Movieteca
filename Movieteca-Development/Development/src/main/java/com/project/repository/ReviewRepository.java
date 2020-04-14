package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
