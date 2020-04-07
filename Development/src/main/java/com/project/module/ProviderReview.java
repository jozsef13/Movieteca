package com.project.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "providerReview")
public class ProviderReview extends Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "providerId", nullable = false)
	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
