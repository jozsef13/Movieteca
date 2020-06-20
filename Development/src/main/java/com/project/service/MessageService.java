package com.project.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.module.Customer;
import com.project.module.Message;
import com.project.module.MyUserDetails;
import com.project.module.Provider;
import com.project.module.User;
import com.project.repository.CustomerRepository;
import com.project.repository.MessageRepository;
import com.project.repository.ProviderRepository;

@Service
public class MessageService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private MessageRepository messageRepository;

	public User sendMessageTo(int id, Message message) {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userDetails.getUser();
		User newUser = new User();
		User receiveUser = new User();
		if (user.getUserType().equals("Provider")) {
			Customer customer = customerRepository.getOne(id);
			Provider provider = providerRepository.getOne(user.getId());
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String formatedNow = now.format(myFormat);
			message.setSentDateTime(formatedNow);

			message.setMessageType("Sent");
			provider.getMessages().add(message);
			message.setCustomer(customer);
			message.setProvider(provider);

			newUser = provider;
			messageRepository.saveAndFlush(message);
			receiveUser = customer;
		} else if (user.getUserType().equals("Customer")) {
			Customer customer = customerRepository.getOne(user.getId());
			Provider provider = providerRepository.getOne(id);
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String formatedNow = now.format(myFormat);
			message.setSentDateTime(formatedNow);

			message.setMessageType("Sent");
			customer.getMessages().add(message);
			message.setCustomer(customer);
			message.setProvider(provider);

			newUser = customer;
			messageRepository.saveAndFlush(message);
			receiveUser = provider;
		}

		userDetails.setUser(newUser);
		return receiveUser;
	}
}
