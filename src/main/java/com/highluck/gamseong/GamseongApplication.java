package com.highluck.gamseong;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GamseongApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamseongApplication.class, args);
	}
}
