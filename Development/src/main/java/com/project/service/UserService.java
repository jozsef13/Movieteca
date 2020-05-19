package com.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.persistence.EntityNotFoundException;
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
import com.project.module.ProviderReview;
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

		if (userTypeRole == null || userTypeRole.isEmpty()) {
			userTypeRole = request.getAttribute("userType").toString();
		}

		System.out.println(passwordEncoder.encode("gabrielAdmin"));

		User user = new User();
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

	public User userExists(String userName) {
		if (adminRepository.findByUserName(userName) != null) {
			return adminRepository.findByUserName(userName);
		} else if (providerRepository.findByUserName(userName) != null) {
			return providerRepository.findByUserName(userName);
		} else if (customerRepository.findByUserName(userName) != null) {
			return customerRepository.findByUserName(userName);
		} else {
			throw new EntityNotFoundException();
		}
	}

	public void save(User user, String userType) {
		user.setUserType(userType);

		if (userType.equals("Customer")) {
			Customer customer = createCustomer(user);
			customerRepository.save(customer);
		} else {
			Provider provider = createProvider(user);
			String paymentPlanName = request.getParameter("paymentPlan");
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
		if (!user.getPassword().equals(lastCustomer.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} else {
			user.setPassword(lastCustomer.getPassword());
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
		user.setReceivedReviews(lastProvider.getReceivedReviews());
		user.setRequestsSent(lastProvider.getRequestsSent());
		user.setMessages(lastProvider.getMessages());
		String paymentPlanName = request.getParameter("paymentPlanText");
		PaymentPlan paymentPlan = paymentPlanRepository.findByPlanType(PlanType.valueOf(paymentPlanName));
		if (paymentPlan != lastProvider.getPaymentPlan()) {
			user.setPaymentPlan(paymentPlan);
		} else {
			user.setPaymentPlan(lastProvider.getPaymentPlan());
		}
		if (!user.getPassword().equals(lastProvider.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		} else {
			user.setPassword(lastProvider.getPassword());
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
		if (!user.getPassword().equals(lastAdmin.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		user.setUserType(lastAdmin.getUserType());
		user.setActive(true);
		userDetails.setUser(user);

		adminRepository.save(user);

	}

	public void deleteUser(User user) {
		if (user.getUserType().equals("Admin")) {
			Admin admin = adminRepository.getOne(user.getId());
			adminRepository.delete(admin);
			adminRepository.flush();
		} else if (user.getUserType().equals("Provider")) {
			Provider provider = providerRepository.getOne(user.getId());
			providerRepository.delete(provider);
			providerRepository.flush();
		} else if (user.getUserType().equals("Customer")) {
			Customer customer = customerRepository.getOne(user.getId());
			customerRepository.delete(customer);
			customerRepository.flush();
		}
	}

	public Provider getProviderById(int id) {
		return providerRepository.getOne(id);
	}

	public User getUserById(int id) {
		if (adminRepository.existsById(id)) {
			return adminRepository.getOne(id);
		} else if (providerRepository.existsById(id)) {
			return providerRepository.getOne(id);
		} else if (customerRepository.existsById(id)) {
			return customerRepository.getOne(id);
		} else {
			throw new EntityNotFoundException();
		}
	}

	public Provider addReviewToProvider(int id, ProviderReview review) {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Customer customer = (Customer) userDetails.getUser();
		Provider provider = providerRepository.getOne(id);
		review.setCustomer(customer);
		review.setProvider(provider);
		customer.getProviderReviewsAdded().add(review);
		provider.getReceivedReviews().add(review);
		provider.setAverageRating();
		provider.setNrOfReviews();

		providerRepository.save(provider);
		return provider;
	}

	public User banUser(int id) {
		User user = getUserById(id);
		user.setActive(false);
		if (user.getUserType().equals("Customer")) {
			Customer customer = (Customer) user;
			customerRepository.save(customer);
		} else if (user.getUserType().equals("Provider")) {
			Provider provider = (Provider) user;
			providerRepository.save(provider);
		}
		return user;
	}

	public User activateAccount(int id) {
		User user = getUserById(id);
		user.setActive(true);
		if (user.getUserType().equals("Customer")) {
			Customer customer = (Customer) user;
			customerRepository.save(customer);
		} else if (user.getUserType().equals("Provider")) {
			Provider provider = (Provider) user;
			providerRepository.save(provider);
		}
		return user;
	}
}
