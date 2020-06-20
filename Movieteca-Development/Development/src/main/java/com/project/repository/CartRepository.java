package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
