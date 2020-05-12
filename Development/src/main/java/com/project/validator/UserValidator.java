package com.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.module.User;
import com.project.service.UserService;

@Component
public class UserValidator {
	@Autowired
	private UserService userService;

	public List<String> validate(User user) {
		List<String> errors = new ArrayList<String>();

		if (user.getUserType() == null) {
			errors.add("You must choose a role!");
		} else {
			if (userService.userExists(user.getUserName())) {
				errors.add("Username " + user.getUserName() + " is already taken! Choose another one!");
			}
			if (user.getPassword().length() < 8) {
				errors.add("Password is too short! It has to be minimum 8 characters!");
			}
			if (!user.getPassword().equals(user.getPasswordConfirm())) {
				errors.add("Confirmation password does not match!");
			}
			if (user.getPassword().matches("[0-9]+")) {
				errors.add("The password must contain at least one letter!");
			}
			if(userService.emailExists(user.getEmail())) {
				errors.add("User with email " + user.getEmail() + " is already registered!" );
			}
		}
		
		return errors;
	}
}