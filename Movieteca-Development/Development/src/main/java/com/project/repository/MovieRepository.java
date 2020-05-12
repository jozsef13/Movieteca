package com.project.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.module.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByGenre(String genre);
	@Query("select s from Movie s where name like %?1%")
	List<Movie> findByName(String name, PageRequest pageRequest);
	@Query("select s from Movie s where name like %?1%")
	List<Movie> findByName(String name);
}
