package com.fede587.ospedale.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fede587.ospedale")
@EntityScan(basePackages = "com.fede587.ospedale.core.entity")
@EnableJpaRepositories(basePackages = "com.fede587.ospedale.core.repository")
public class OspedaleWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(OspedaleWebApplication.class, args);
	}
}
