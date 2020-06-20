package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
