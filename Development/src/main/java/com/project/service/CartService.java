package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.application.MovietecaApplication;
import com.project.module.Cart;
import com.project.module.Movie;
import com.project.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public Cart addMovieToCart(Movie movie, String type, int quntityInt) {
		if (cartRepository.count() < 1) {
			Cart cart = createCart();
			MovietecaApplication.cartId = cart.getId();
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cartMovie.setOrderQuantity(quntityInt);
			cart.getMoviesInCart().add(cartMovie);
			if (type.equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getBuyPrice()));
			} else if (type.equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getRentPrice()));
			}
			cartRepository.save(cart);
			return cart;
		} else {
			Cart cart = getCartById(MovietecaApplication.cartId);
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cartMovie.setOrderQuantity(quntityInt);
			cart.getMoviesInCart().add(cartMovie);
			if (type.equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getBuyPrice()));
			} else if (type.equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + (quntityInt * movie.getRentPrice()));
			}
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

	public void deleteCart(Cart cart) {
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
