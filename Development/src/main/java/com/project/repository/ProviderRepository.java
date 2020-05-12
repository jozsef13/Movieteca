package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

	Provider findByUserName(String userName);

	Provider findByEmail(String email);

}
