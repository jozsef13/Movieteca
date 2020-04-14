package com.project.module;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`providerReview`")
public class ProviderReview extends Review {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int providerReviewId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "providerId", nullable = false)
	private Provider provider;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getProviderReviewId() {
		return providerReviewId;
	}

	public void setProviderReviewId(int providerReviewId) {
		this.providerReviewId = providerReviewId;
	}
}
