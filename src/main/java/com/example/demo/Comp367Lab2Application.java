package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Comp367Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Comp367Lab2Application.class, args);
	}

    @RestController
    class HelloWorldController {
        @GetMapping("/")
        public String hello() {
            return "Welcome to Comp367!";
        }
    }
}
