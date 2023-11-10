package com.smartubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmartUbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartUbsApplication.class, args);
	}

}
