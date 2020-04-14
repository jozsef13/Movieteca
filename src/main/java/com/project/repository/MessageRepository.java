package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
