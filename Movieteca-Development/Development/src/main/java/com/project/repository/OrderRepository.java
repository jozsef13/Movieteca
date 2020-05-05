package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
