package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.module.Cart;
import com.project.module.Customer;
import com.project.module.Movie;
import com.project.module.MyUserDetails;
import com.project.repository.CartRepository;
import com.project.repository.CustomerRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public Cart addMovieToCart(Movie movie, String type, int quntityInt, MyUserDetails userDetails) {
		Customer customer = (Customer) userDetails.getUser();
		if (customer.getCart() == null) {
			Cart cart = createCart();
			cart.setCustomer(customer);
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cartMovie.setOrderQuantity(quntityInt);
			cart.getMoviesInCart().add(cartMovie);
			if (type.equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getBuyPrice()));
			} else if (type.equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getRentPrice()));
			}
			customer.setCart(cart);
			customerRepository.save(customer);
			cartRepository.save(cart);
			return cart;
		} else {
			Cart cart = customer.getCart();
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cartMovie.setOrderQuantity(quntityInt);
			cart.getMoviesInCart().add(cartMovie);
			if (type.equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getBuyPrice()));
			} else if (type.equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getRentPrice()));
			}
			customer.setCart(cart);
			customerRepository.save(customer);
			cartRepository.save(cart);
			return cart;
		}
	}

	public Cart getCartById(int id) {
		return cartRepository.findById(id).orElse(null);
	}

	public Cart createCart() {
		Cart cart = new Cart();
		cartRepository.save(cart);
		return cart;
	}

	public Cart deleteMovieFromCart(Movie movie, Cart cart) {
		if (movie.getOrderType().equals("Buy")) {
			cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getBuyPrice()));
		} else if (movie.getOrderType().equals("Rent")) {
			cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getRentPrice()));
		}

		cart.getMoviesInCart().remove(movie);
		if (cart.getMoviesInCart().isEmpty()) {
			cart.setTotalPrice(0);
		}
		cartRepository.save(cart);
		return cart;
	}

	public void deleteCart(Cart cart, Customer customer) {
		customer.setCart(null);
		customerRepository.save(customer);
		cartRepository.delete(cart);
	}

	public Cart update(Movie movie, Cart cart, int quantity) {
		if (quantity <= 0) {
			deleteMovieFromCart(movie, cart);
		} else {
			if (movie.getOrderType().equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getBuyPrice()));
			} else if (movie.getOrderType().equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getRentPrice()));
			}

			movie.setOrderQuantity(quantity);
			cart.getMoviesInCart().add(movie);

			if (movie.getOrderType().equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + (movie.getOrderQuantity() * movie.getBuyPrice()));
			} else if (movie.getOrderType().equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + (movie.getOrderQuantity() * movie.getRentPrice()));
			}
		}

		return cartRepository.save(cart);
	}

	public Cart updateType(Movie movie, Cart cart, String type) {
		if (movie.getOrderType().equals("Buy")) {
			cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getBuyPrice()));
		} else if (movie.getOrderType().equals("Rent")) {
			cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getRentPrice()));
		}
		
		movie.setOrderType(type);
		cart.getMoviesInCart().add(movie);
		
		if (movie.getOrderType().equals("Buy")) {
			cart.setTotalPrice(cart.getTotalPrice() + (movie.getOrderQuantity() * movie.getBuyPrice()));
		} else if (movie.getOrderType().equals("Rent")) {
			cart.setTotalPrice(cart.getTotalPrice() + (movie.getOrderQuantity() * movie.getRentPrice()));
		}
		
		return cartRepository.save(cart);
	}
}
