package com.example.mangav2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient;
@RestController;
public class Mangav2Application {
	@RequestMapping("/")
	public String mangav2() {
		return "some mangav2s";
	}

	public static void main(String[] args) {
		SpringApplication.run(Mangav2Application.class, args);
	}

}
