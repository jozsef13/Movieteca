package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.PaymentPlan;

public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Integer> {

}
