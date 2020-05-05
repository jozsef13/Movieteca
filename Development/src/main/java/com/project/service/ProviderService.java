package com.project.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.module.Provider;
import com.project.repository.ProviderRepository;

@Service
public class ProviderService {
	@Autowired
	private ProviderRepository providerRepo;
	
	public void addProvider(Provider provider) {
		providerRepo.save(provider);
	}
	
	public Provider getProviderById(int id) {
		return providerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
}
