package com.project.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.project.module"})
@EnableJpaRepositories("com.project.repository")
@ComponentScan({ "com.project.controller", "com.project.service" })
@SpringBootApplication
public class MovietecaApplication {

	public static int cartId = 0;
	
	public static void main(String[] args) {
		SpringApplication.run(MovietecaApplication.class, args);
	}

}
