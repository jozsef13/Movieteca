package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {

}
