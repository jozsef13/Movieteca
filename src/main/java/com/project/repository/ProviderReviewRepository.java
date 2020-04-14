package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.ProviderReview;

@Repository
public interface ProviderReviewRepository extends JpaRepository<ProviderReview, Integer> {

}
