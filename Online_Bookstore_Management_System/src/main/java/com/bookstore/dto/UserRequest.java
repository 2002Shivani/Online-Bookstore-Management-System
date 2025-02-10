package com.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	private String userEmail;
	private String userName;
	private String userPassword;
	private String userCity;
	private long userPhone;
	private String userRole;
	
	
}
