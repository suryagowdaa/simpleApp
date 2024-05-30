package com.example.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
		System.out.println("Hi, Check");
		System.out.println("Another one");
		SpringApplication.run(SimpleApplication.class, args);
	}

}
