package com.project.module;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="`paymentPlan`")
public class PaymentPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String planType;
	private float price;
//	@OneToMany(mappedBy = "paymentPlan", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Provider> providers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Set<Provider> getProviders() {
//		return providers;
//	}
//
//	public void setProviders(Set<Provider> providers) {
//		this.providers = providers;
//	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
