package com.bookstore.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entities.User;
import com.bookstore.model.LoginRequest;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/bookstore/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<Integer> userInsert(@RequestBody User user) {
		User registerUser = service.userInsert(user);
		if (registerUser != null) {
			return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Integer>(3, HttpStatus.OK);
		}
	}

	// User Login

	@PostMapping("/login")
	public User userLogin(@RequestBody LoginRequest loginRequest) {

		return service.userLogin(loginRequest);
	}

	// update user

	@PutMapping("/update")
	public User userUpdate(@RequestBody User user,@RequestParam String email) {

		return service.userUpdate(user, email);
	}

	// get all user
	@GetMapping("/getall")
	public Set<User> getAllUser() {
		return service.getAllUser();
	}

	// get user by name

	@GetMapping("/getbyemail")
	public User getUserByEmail(@RequestParam String email) {
		return service.getUserByEmail(email);
	}

	@GetMapping("/byrole")
	public Set<User> getSpecific(@RequestParam String role) {
		return service.getSpecific(role);
	}
	
}
