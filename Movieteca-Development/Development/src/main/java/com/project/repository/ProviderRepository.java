package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
