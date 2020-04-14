package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.repository.RequestRepository;

@RestController
@RequestMapping(RequestController.CONTRACT_BASE_URL)
public class RequestController {

	public static final String CONTRACT_BASE_URL = "/request";
	@Autowired
	private RequestRepository requestRepo;
}
