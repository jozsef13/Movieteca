package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.repository.MovieRepository;

@RestController
@RequestMapping(MovieController.CONTRACT_BASE_URL)
public class MovieController {
	
	public static final String CONTRACT_BASE_URL = "/movie";
	@Autowired
	private MovieRepository movieRepo;
}
