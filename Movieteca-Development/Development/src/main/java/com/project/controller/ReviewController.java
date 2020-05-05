package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.repository.ReviewRepository;

@RestController
@RequestMapping(ReviewController.CONTRACT_BASE_URL)
public class ReviewController {
	
	public static final String CONTRACT_BASE_URL = "/review";
	@Autowired
	private ReviewRepository reviewRepo;
}
