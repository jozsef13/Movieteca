package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
