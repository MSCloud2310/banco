package com.example.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Para configura Spring Boot para despliegue en Tomcat: https://stackoverflow.com/a/24824512
@SpringBootApplication
public class BancoApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}
