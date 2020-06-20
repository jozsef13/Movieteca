package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
