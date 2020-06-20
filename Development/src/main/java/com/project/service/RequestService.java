package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.module.Admin;
import com.project.module.Customer;
import com.project.module.MyUserDetails;
import com.project.module.Provider;
import com.project.module.Request;
import com.project.module.RequestStatus;
import com.project.module.User;
import com.project.repository.AdminRepository;
import com.project.repository.CustomerRepository;
import com.project.repository.ProviderRepository;
import com.project.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private RequestRepository requestRepository;

	public void sendRequest(Request request) {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userDetails.getUser();
		List<Admin> admins = adminRepository.findAll();
		Admin requestAdmin = new Admin();
		if (admins.size() == 1) {
			requestAdmin = admins.get(0);
		} else {
			List<Integer> adminsIds = new ArrayList<Integer>();
			for (Admin admin : admins) {
				adminsIds.add(admin.getId());
			}

			Random rand = new Random();
			int randomId = adminsIds.get(rand.nextInt(adminsIds.size()));
			requestAdmin = admins.get(randomId);
		}
		requestAdmin.getReceivedRequests().add(request);
		request.setAdmin(requestAdmin);
		if (user.getUserType().equals("Provider")) {
			Provider provider = (Provider) user;
			request.setProvider(provider);
			provider.getRequestsSent().add(request);
			userDetails.setUser(provider);
		} else if (user.getUserType().equals("Customer")) {
			Customer customer = (Customer) user;
			request.setCustomer(customer);
			customer.getRequestsSent().add(request);
			userDetails.setUser(customer);
		}
		
		adminRepository.save(requestAdmin);
	}

	public Request getRequestById(int id) {
		return requestRepository.getOne(id);
	}

	public Request approve(int id, String message) {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Admin admin = (Admin) userDetails.getUser();
		Request request = requestRepository.getOne(id);
		if (message != null) {
			if (!message.equals(request.getRequestObject())) {
				request.setRequestObject(message);
			}
		}
		request.setStatus(RequestStatus.Approved);
		if(request.getProvider() != null) {
			Provider provider = providerRepository.getOne(request.getProvider().getId());
			provider.getRequestsSent().add(request);
			provider.setPermission(true);
			providerRepository.save(provider);
		} else if(request.getCustomer() != null) {
			Customer customer = customerRepository.getOne(request.getCustomer().getId());
			customer.getRequestsSent().add(request);
			customerRepository.save(customer);
		}
		
		admin.getReceivedRequests().add(request);
		return request;
	}

	public Request deny(int id, String message) {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Admin admin = (Admin) userDetails.getUser();
		Request request = requestRepository.getOne(id);
		if (!message.equals(request.getRequestObject())) {
			request.setRequestObject(message);
		}
		request.setStatus(RequestStatus.Denied);
		Provider provider = providerRepository.getOne(request.getProvider().getId());
		provider.getRequestsSent().add(request);
		provider.setPermission(true);
		admin.getReceivedRequests().add(request);

		providerRepository.save(provider);
		return request;
	}

}
