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

	public Cart addMovieToCart(Movie movie, String type) {
		if (cartRepository.count() < 1) {
			Cart cart = createCart();
			MovietecaApplication.cartId = cart.getId();
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cart.getMoviesInCart().add(cartMovie);
			if (type.equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + movie.getBuyPrice());
			} else if (type.equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + movie.getRentPrice());
			}
			cartRepository.save(cart);
			return cart;
		} else {
			Cart cart = getCartById(MovietecaApplication.cartId);
			Movie cartMovie = movie;
			cartMovie.setOrderType(type);
			cart.getMoviesInCart().add(cartMovie);
			if (type.equals("Buy")) {
				cart.setTotalPrice(cart.getTotalPrice() + movie.getBuyPrice());
			} else if (type.equals("Rent")) {
				cart.setTotalPrice(cart.getTotalPrice() + movie.getRentPrice());
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
		if(movie.getOrderType().equals("Buy")) {
			cart.setTotalPrice(cart.getTotalPrice() - movie.getBuyPrice());
		} else if(movie.getOrderType().equals("Rent")) {
			cart.setTotalPrice(cart.getTotalPrice() - movie.getRentPrice());
		}
		
		cart.getMoviesInCart().remove(movie);
		if(cart.getMoviesInCart().isEmpty()) {
			cart.setTotalPrice(0);
		}
		cartRepository.save(cart);
		return cart;
	}

	public void deleteCart(Cart cart) {
		cartRepository.delete(cart);
	}
}
