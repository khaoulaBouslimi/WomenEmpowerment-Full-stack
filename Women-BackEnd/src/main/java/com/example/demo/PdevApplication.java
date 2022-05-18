package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableJpaAuditing
@EnableWebMvc
@SpringBootApplication

public class PdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdevApplication.class, args);
	}
	

}
