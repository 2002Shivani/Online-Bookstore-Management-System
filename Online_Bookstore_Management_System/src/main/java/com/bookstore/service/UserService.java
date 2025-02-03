package com.bookstore.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.UserDao;
import com.bookstore.entities.User;
import com.bookstore.model.LoginRequest;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public User userInsert(User user) {
		return dao.userInsert(user);
	}

	// User Login

	public User userLogin(LoginRequest loginRequest) {

		return dao.userLogin(loginRequest);
	}

	// update user

	public User userUpdate(User user, String email) {

		return dao.userUpdate(user, email);
	}

	// get all user
	public Set<User> getAllUser() {

		return dao.getAllUser();
	}

	// get user by name

	public User getUserByEmail(String email) {

		return dao.getUserByEmail(email);
	}

	public Set<User> getSpecific(String role) {
		
		return dao.getSpecific(role);
	}
}
