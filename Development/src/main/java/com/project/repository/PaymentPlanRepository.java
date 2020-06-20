package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.PaymentPlan;
import com.project.module.PlanType;

@Repository
public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Integer> {

	PaymentPlan findByPlanType(PlanType planType);

}
