package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.module.Message;
import com.project.module.User;
import com.project.service.MessageService;
import com.project.service.UserService;

@RestController
public class MessageController {

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/sendMessage/{id}")
	public ModelAndView sendMessagePage(@PathVariable int id) {
		ModelAndView model = new ModelAndView("chat");
		User user = userService.getUserById(id);
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping(value = "/sendMessage/to/{id}")
	public ModelAndView sendMessage(@PathVariable int id, Message message) {
		ModelAndView model = new ModelAndView("chat");
		User user = messageService.sendMessageTo(id, message);
		model.addObject("user", user);
		return model;
	}
}
