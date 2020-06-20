package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Request;
import com.project.service.RequestService;

@RestController
public class ContactController {
	
	@Autowired
	private RequestService requestService;

	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {
		ModelAndView model = new ModelAndView("contact");
		return model;
	}
	
	@RequestMapping(value="/contact/sendRequest")
	public ModelAndView sendRequest(Request request) {
		ModelAndView model = new ModelAndView("contact");
		requestService.sendRequest(request);
		String message = "Successfuly sent the request or the message!";
		model.addObject("errorMessage", message);
		return model;
	}
	
	@RequestMapping(value = "/request/{id}")
	public ModelAndView getRequestById(@PathVariable int id) {
		ModelAndView model = new ModelAndView("contact");
		Request request = requestService.getRequestById(id);
		model.addObject("request", request);
		return model;
	}
	
	@RequestMapping(value="/contact/request/approve/{id}")
	public ModelAndView approveRequest(@PathVariable int id, HttpServletRequest servletRequest) {
		ModelAndView model = new ModelAndView("contact");
		String message = servletRequest.getParameter("requestObject");
		Request updatedRequest = requestService.approve(id, message);
		String errorMessage = "Successfuly approved the request!";
		model.addObject("errorMessage", errorMessage);
		model.addObject(updatedRequest);
		return model;
	}
	
	@RequestMapping(value="/contact/request/deny/{id}")
	public ModelAndView denyRequest(@PathVariable int id, HttpServletRequest servletRequest) {
		ModelAndView model = new ModelAndView("contact");
		String message = servletRequest.getParameter("requestObject");
		Request updatedRequest = requestService.deny(id, message);
		String errorMessage = "Successfuly denied the request!";
		model.addObject("errorMessage", errorMessage);
		model.addObject(updatedRequest);
		return model;
	}
}
