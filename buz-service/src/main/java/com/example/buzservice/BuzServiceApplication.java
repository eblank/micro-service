package com.example.buzservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BuzServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuzServiceApplication.class, args);
	}

}

