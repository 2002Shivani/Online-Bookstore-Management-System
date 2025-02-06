package com.bookstore.dto;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import com.bookstore.entities.Order;
import com.bookstore.entities.Role;
import com.bookstore.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
