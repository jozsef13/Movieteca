package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.module.Cart;
import com.project.module.Customer;
import com.project.module.Movie;
import com.project.repository.CartRepository;
import com.project.repository.CustomerRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public Cart addMovieToCart(Movie movie, String type, int quntityInt, Customer customer) {
		int cartId = 0;
		if(customer.getCart() != null) {
			 cartId = customer.getCart().getId();
		}
		if (cartId == 0) {
			Cart cart = createCart(customer);
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
			cartRepository.save(cart);
			customerRepository.save(customer);
			return cart;
		} else {
			Cart cart = cartRepository.getOne(cartId);
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cartMovie.setOrderQuantity(quntityInt);
			cart.getMoviesInCart().add(cartMovie);
			cartMovie.getCarts().add(cart);
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

	public Cart createCart(Customer customer) {
		Cart cart = new Cart();
		cart.setCustomer(customer);
		return cart;
	}

	public Cart deleteMovieFromCart(Movie movie, Cart cart) {
		if (movie.getOrderType().equals("Buy")) {
			cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getBuyPrice()));
		} else if (movie.getOrderType().equals("Rent")) {
			cart.setTotalPrice(cart.getTotalPrice() - (movie.getOrderQuantity() * movie.getRentPrice()));
		}
		
		System.out.println(cart + " " + cart.getMoviesInCart());
		for (Movie movieInCart : cart.getMoviesInCart()) {
			if(movieInCart.getId() == movie.getId()) {
				cart.getMoviesInCart().remove(movieInCart);
				break;
			}
		}
		
		
		if (cart.getMoviesInCart().isEmpty()) {
			cart.setTotalPrice(0);
		}
		
		cartRepository.saveAndFlush(cart);
		return cart;
	}

	public void deleteCart(Cart cart, Customer customer) {
		customer.setCart(null);
		customerRepository.save(customer);
		cartRepository.delete(cart);
	}

	public Cart update(Movie movie, int cartId, int quantity) {
		Cart cart = cartRepository.getOne(cartId);
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

	public Cart updateType(Movie movie, int cartId, String type) {
		Cart cart = cartRepository.getOne(cartId);
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
		cartRepository.save(cart);
		return cart;
	}
}
