package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.entities.User;

@SpringBootApplication
public class OnlineBookstoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookstoreManagementSystemApplication.class, args);
		System.out.println("Bookstore Management System application is Running.....");
		
	
	}

}
