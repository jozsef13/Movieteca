package com.project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.module.Cart;
import com.project.module.Movie;
import com.project.module.Order;
import com.project.module.OrderStatus;
import com.project.repository.MovieRepository;
import com.project.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private MovieRepository movieRepository;

	public Order placeOrder(Cart cart) {
		Order order = new Order();
		order.getOrederedMovies().addAll(cart.getMoviesInCart());
		for (Movie movie : order.getOrederedMovies()) {
			movie.setStock(movie.getStock() - movie.getOrderQuantity());
			if(movie.getOrderType().equals("Rent")) {
				movie.setReturningDate(dateTime());
			}
		}
		movieRepository.saveAll(order.getOrederedMovies());
		order.setStatus(OrderStatus.Placed);
		order.setTotalPrice(cart.getTotalPrice());
		orderRepository.save(order);
		return order;
	}

	private String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate local = LocalDate.now();
		LocalDate returnDay = local.plusDays(14);
		return dtf.format(returnDay);
	}

	public Order getOrderById(int id) {
		return orderRepository.getOne(id);
	}

}
