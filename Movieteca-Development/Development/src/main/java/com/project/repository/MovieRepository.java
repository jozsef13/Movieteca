package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
