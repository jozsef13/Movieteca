package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Admin;
import com.project.module.Customer;
import com.project.module.MyUserDetails;
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

	@RequestMapping(value = "/registerAs")
	public ModelAndView registeAsPage(HttpServletRequest request) {
		String userType = request.getParameter("userType");
		ModelAndView model = new ModelAndView();

		if (userType.equals("Customer")) {
			model.setViewName("signupCustomer");
			model.addObject("userType", userType);
		} else if (userType.equals("Provider")) {
			model.setViewName("signupProvider");
			model.addObject("userType", userType);
		}

		return model;
	}

	@PostMapping("/register/{userType}")
	public ModelAndView register(User userForm, @PathVariable String userType, HttpServletRequest request) {
		List<String> results = userValidator.validate(userForm);

		if (!results.isEmpty()) {
			if(userType.equals("Customer")) {
				ModelAndView model = new ModelAndView("signupCustomer");
				model.addObject("errorMessage", results);
				return model;
			} else if(userType.equals("Provider")) {
				ModelAndView model = new ModelAndView("signupProvider");
				model.addObject("errorMessage", results);
				return model;
			}	
		}

		ModelAndView model = new ModelAndView("myaccount");
		request.setAttribute("userType", userType);
		userService.save(userForm, userType);
		userService.autoLogin(userForm.getUserName(), userForm.getPassword());
		model.addObject("errorMessage", "You successfuly created you account!");
		
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
		return model;
	}

	@RequestMapping(value = "/user/edit/Provider")
	public ModelAndView editProfileCustomer(@RequestParam("img") MultipartFile img, Provider user) throws IOException {
		ModelAndView model = new ModelAndView("myaccount");
		userService.updateProvider(user, img);
		return model;
	}

	@RequestMapping(value = "/user/edit/Admin")
	public ModelAndView editProfileCustomer(@RequestParam("img") MultipartFile img, Admin user) throws IOException {
		ModelAndView model = new ModelAndView("myaccount");
		userService.updateAdmin(user, img);
		return model;
	}

	@RequestMapping(value = "/editProfile")
	public ModelAndView editProfilePage() {
		ModelAndView model = new ModelAndView("editProfile");
		return model;
	}

	@RequestMapping(value = "/forbidden")
	public ModelAndView forbiddenPage() {
		ModelAndView model = new ModelAndView("forbidden");
		return model;
	}

	@RequestMapping(value="/user/delete/{id}")
	public ModelAndView deleteUser(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
		User user = userDetails.getUser();
		
		if(user.getId() == id) {
			userService.deleteUser(user);
			if(auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			SecurityContextHolder.getContext().setAuthentication(null);
			ModelAndView model = new ModelAndView("login");
			String errorMessage = "Your account was successfuly deleted!";
			model.addObject("errorMessage", errorMessage);
			return model ;
		} else {
			return new ModelAndView("forbidden");
		}
	}

}
