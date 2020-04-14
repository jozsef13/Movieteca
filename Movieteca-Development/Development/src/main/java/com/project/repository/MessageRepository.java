package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
