package com.bookstore.controller;

import java.util.List;
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
import com.bookstore.dto.LoginRequest;
import com.bookstore.dto.UserRequest;
import com.bookstore.entities.Role;
import com.bookstore.entities.User;
import com.bookstore.service.RoleService;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/bookstore/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private RoleService roleService;

	@PostMapping("/register")
	public ResponseEntity<Integer> userInsert(@RequestBody UserRequest user) {
		Role r = roleService.getSpecificRole(user.getUserRole());
		User u = new User();
		u.setUserEmail(user.getUserEmail());
		u.setUserName(user.getUserName());
		u.setUserPassword(user.getUserPassword());
		u.setUserCity(user.getUserCity());
		u.setUserPhone(user.getUserPhone());
		u.setUserRole(r);

		User registerUser = service.userInsert(u);

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
	public User userUpdate(@RequestBody User user) {
		return service.userUpdate(user);
	}

	// get all user
	@GetMapping("/getall")
	public List<User> getAllUser() {
		return service.getAllUser();
	}

	// get user by name

	@GetMapping("/getbyemail")
	public User getUserByEmail(@RequestParam String userEmail) {
		return service.getUserByEmail(userEmail);
	}

	@GetMapping("/byrole")
	public List<User> getSpecific(@RequestParam String userRole) {
		Role r = roleService.getSpecificRole(userRole);
		return service.getSpecific(r);
	}

}
