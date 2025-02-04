package com.bookstore.model;

import lombok.Data;

@Data
public class LoginRequest {

	private String userEmail;
	private String userPassword;
	
}
