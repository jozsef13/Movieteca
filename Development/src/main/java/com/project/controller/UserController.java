package com.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Admin;
import com.project.module.Customer;
import com.project.module.Provider;
import com.project.module.User;
import com.project.service.UserService;
import com.project.validator.UserValidator;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = "/login")
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView("login");
		String errorMessage = null;
		if (error != null) {
			errorMessage = "Incorrect username or password!";
		}
		if (logout != null) {
			errorMessage = "You successfully logged out!";
		}
		model.addObject("errorMessage", errorMessage);
		return model;
	}

	@GetMapping("/register")
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("signup");
		return model;
	}

	@PostMapping("/register")
	public ModelAndView register(User userForm) {
		List<String> results = userValidator.validate(userForm);

		if (!results.isEmpty()) {
			ModelAndView model = new ModelAndView("signup");
			model.addObject("errorMessage", results);
			return model;
		}
		
		ModelAndView model = new ModelAndView("myaccount");
		userService.save(userForm);
		userService.autoLogin(userForm.getUserName(), userForm.getPassword());
		
		return model;
	}

	@RequestMapping(value = "/myaccount")
	public ModelAndView myAccountPage() {
		ModelAndView model = new ModelAndView("myaccount");
		return model;
	}
	
	@RequestMapping(value = "/user/edit/Customer")
	public ModelAndView editProfileCustomer(@RequestParam("img") MultipartFile img, Customer user) throws IOException {
		ModelAndView model = new ModelAndView("myaccount");
		userService.updateCustomer(user, img);
		return model ;
	}
	
	@RequestMapping(value = "/user/edit/Provider")
	public ModelAndView editProfileCustomer(@RequestParam("img") MultipartFile img, Provider user) throws IOException {
		ModelAndView model = new ModelAndView("myaccount");
		userService.updateProvider(user, img);
		return model ;
	}
	
	@RequestMapping(value = "/user/edit/Admin")
	public ModelAndView editProfileCustomer(@RequestParam("img") MultipartFile img, Admin user) throws IOException {
		ModelAndView model = new ModelAndView("myaccount");
		userService.updateAdmin(user, img);
		return model ;
	}
	
	@RequestMapping(value = "/editProfile")
	public ModelAndView editProfilePage() {
		ModelAndView model = new ModelAndView("editProfile");
		return model ;
	}

}
