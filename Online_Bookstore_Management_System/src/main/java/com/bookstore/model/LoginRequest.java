package com.bookstore.model;

import lombok.Data;

@Data
public class LoginRequest {

	private int userId;
	private String userPassword;
	
}
