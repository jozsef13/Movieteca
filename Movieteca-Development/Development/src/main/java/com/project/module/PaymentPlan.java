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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private PlanType planType;
	private double price;
	@OneToMany(mappedBy = "paymentPlan", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Provider> providers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Provider> getProviders() {
		return providers;
	}

	public void setProviders(Set<Provider> providers) {
		this.providers = providers;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
