package com.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.multipart.MultipartFile;

import com.project.module.Admin;
import com.project.module.Customer;
import com.project.module.MyUserDetails;
import com.project.module.PaymentPlan;
import com.project.module.PlanType;
import com.project.module.Provider;
import com.project.module.User;
import com.project.repository.AdminRepository;
import com.project.repository.CustomerRepository;
import com.project.repository.PaymentPlanRepository;
import com.project.repository.ProviderRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PaymentPlanRepository paymentPlanRepository;

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		if (userName == null || userName.isEmpty()) {
			throw new UsernameNotFoundException("Username field is empty!");
		}

		String userTypeRole = request.getParameter("userType");
		User user = null;
		if (userTypeRole.equals("Admin")) {
			user = adminRepository.findByUserName(userName);
			if (user == null) {
				throw new UsernameNotFoundException("Not found: " + userName);
			}
			return new MyUserDetails((Admin) user);
		} else if (userTypeRole.equals("Provider")) {
			user = providerRepository.findByUserName(userName);
			if (user == null) {
				throw new UsernameNotFoundException("Not found: " + userName);
			}
			return new MyUserDetails((Provider) user);
		} else {
			user = customerRepository.findByUserName(userName);
			if (user == null) {
				throw new UsernameNotFoundException("Not found: " + userName);
			}
			return new MyUserDetails((Customer) user);
		}
	}

	public boolean userExists(String userName) {
		if (adminRepository.findByUserName(userName) != null || customerRepository.findByUserName(userName) != null
				|| providerRepository.findByUserName(userName) != null) {
			return true;
		}

		return false;
	}

	public void save(User user) {
		String role = request.getParameter("userType");
		user.setUserType(role);

		if (role.equals("Customer")) {
			Customer customer = createCustomer(user);
			customerRepository.save(customer);
		} else {
			Provider provider = createProvider(user);
			String paymentPlanName =  request.getParameter("paymentPlan");
			PaymentPlan paymentPlan = paymentPlanRepository.findByPlanType(PlanType.valueOf(paymentPlanName));
			provider.setPaymentPlan(paymentPlan);
			paymentPlan.getProviders().add(provider);
			providerRepository.save(provider);
		}

	}

	private Provider createProvider(User user) {
		Provider provider = new Provider();
		provider.setAddress(user.getAddress());
		provider.setBirthDate(user.getBirthDate());
		provider.setCity(user.getCity());
		provider.setCountry(user.getCountry());
		provider.setEmail(user.getEmail());
		provider.setFirstName(user.getFirstName());
		provider.setLastName(user.getLastName());
		provider.setPassword(passwordEncoder.encode(user.getPassword()));
		provider.setPhoneNumber(user.getPhoneNumber());
		provider.setSex(user.getSex());
		provider.setState(user.getState());
		provider.setUserName(user.getUserName());
		provider.setUserType(user.getUserType());
		provider.setActive(true);
		return provider;
	}

	private Customer createCustomer(User user) {
		Customer customer = new Customer();
		customer.setAddress(user.getAddress());
		customer.setBirthDate(user.getBirthDate());
		customer.setCity(user.getCity());
		customer.setCountry(user.getCountry());
		customer.setEmail(user.getEmail());
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setPassword(passwordEncoder.encode(user.getPassword()));
		customer.setPhoneNumber(user.getPhoneNumber());
		customer.setSex(user.getSex());
		customer.setState(user.getState());
		customer.setUserName(user.getUserName());
		customer.setUserType(user.getUserType());
		customer.setActive(true);
		return customer;
	}

	public void autoLogin(String username, String password) {
		UserDetails userDetails = loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

	public boolean emailExists(String email) {
		if (adminRepository.findByEmail(email) != null || customerRepository.findByEmail(email) != null
				|| providerRepository.findByEmail(email) != null) {
			return true;
		}

		return false;
	}

	public void update(User user, MultipartFile img) throws IOException {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String imgFile = "/images/" + img.getOriginalFilename();
		File upl = new File("src/main/resources/static" + imgFile);
		upl.createNewFile();
		FileOutputStream fout = new FileOutputStream(upl);
		fout.write(img.getBytes());
		fout.close();
		user.setProfilePicture(imgFile);
		user.setId(userDetails.getUser().getId());
		user.setPassword(userDetails.getPassword());
		user.setUserType(userDetails.getUser().getUserType());
		userDetails.setUser(user);
		if (userDetails.getUser().getUserType().equals("Admin")) {
			adminRepository.save((Admin) userDetails.getUser());
		} else if (userDetails.getUser().getUserType().equals("Customer")) {
			Customer customer = createCustomer(userDetails.getUser());
			customerRepository.save(customer);
		} else if (userDetails.getUser().getUserType().equals("Provider")) {
			providerRepository.save((Provider) userDetails.getUser());
		}
	}

	public void updateCustomer(Customer user, MultipartFile img) throws IOException {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Customer lastCustomer = customerRepository.findByUserName(user.getUserName());
		if (!img.isEmpty()) {
			String imgFile = "/images/" + img.getOriginalFilename();
			File upl = new File("src/main/resources/static" + imgFile);
			upl.createNewFile();
			FileOutputStream fout = new FileOutputStream(upl);
			fout.write(img.getBytes());
			fout.close();
			user.setProfilePicture(imgFile);
		} else {
			user.setProfilePicture(lastCustomer.getProfilePicture());
		}
		user.setId(userDetails.getUser().getId());
		
		user.setCart(lastCustomer.getCart());
		user.setMessages(lastCustomer.getMessages());
		user.setMovieReviewsAdded(lastCustomer.getMovieReviewsAdded());
		user.setProviderReviewsAdded(lastCustomer.getProviderReviewsAdded());
		user.setOrders(lastCustomer.getOrders());
		if (!user.getPassword().matches(lastCustomer.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		user.setUserType(lastCustomer.getUserType());
		user.setActive(true);
		userDetails.setUser(user);

		customerRepository.save(user);
	}

	public void updateProvider(Provider user, MultipartFile img) throws IOException {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Provider lastProvider = providerRepository.findByUserName(user.getUserName());
		if (!img.isEmpty()) {
			String imgFile = "/images/" + img.getOriginalFilename();
			File upl = new File("src/main/resources/static" + imgFile);
			upl.createNewFile();
			FileOutputStream fout = new FileOutputStream(upl);
			fout.write(img.getBytes());
			fout.close();
			user.setProfilePicture(imgFile);
		} else {
			user.setProfilePicture(lastProvider.getProfilePicture());
		}
		
		user.setId(userDetails.getUser().getId());
		user.setMoviesPosted(lastProvider.getMoviesPosted());
		user.setPaymentPlan(lastProvider.getPaymentPlan());
		user.setReceivedReviews(lastProvider.getReceivedReviews());
		user.setRequestsSent(lastProvider.getRequestsSent());
		user.setMessages(lastProvider.getMessages());
		if (!user.getPassword().matches(lastProvider.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		user.setUserType(lastProvider.getUserType());
		user.setActive(true);
		userDetails.setUser(user);
		
		providerRepository.save(user);
		
	}

	public void updateAdmin(Admin user, MultipartFile img) throws IOException {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Admin lastAdmin = adminRepository.findByUserName(user.getUserName());
		if (!img.isEmpty()) {
			String imgFile = "/images/" + img.getOriginalFilename();
			File upl = new File("src/main/resources/static" + imgFile);
			upl.createNewFile();
			FileOutputStream fout = new FileOutputStream(upl);
			fout.write(img.getBytes());
			fout.close();
			user.setProfilePicture(imgFile);
		} else {
			user.setProfilePicture(lastAdmin.getProfilePicture());
		}
		
		user.setId(userDetails.getUser().getId());
		user.setReceivedRequests(lastAdmin.getReceivedRequests());
		if (!user.getPassword().matches(lastAdmin.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		user.setUserType(lastAdmin.getUserType());
		user.setActive(true);
		userDetails.setUser(user);
		
		adminRepository.save(user);
		
	}
}
