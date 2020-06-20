package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.module.User;
import com.project.repository.UserRepository;

@RestController
@RequestMapping(UserController.CONTRACT_BASE_URL)
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	public static final String CONTRACT_BASE_URL = "/user";
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}
}
