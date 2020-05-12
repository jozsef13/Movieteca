package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByUserName(String userName);

	Customer findByEmail(String email);

}
