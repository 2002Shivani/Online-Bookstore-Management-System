package com.bookstore.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.entities.Role;
import com.bookstore.service.RoleService;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/bookstore/role")
public class RoleContoller {
	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@PostMapping("/insertRole")
	public Role insertRole(@RequestBody Role request) {
		return roleService.insertRole(request);
	}

	@GetMapping("/getAllRole")
	public List<Role> getAllRole() {
		return roleService.getAllRole();
	}

	@GetMapping("/getSpecificRole")
	public Role getSpecificRole(@RequestParam String roleName) {
		return roleService.getSpecificRole(roleName);
	}
}
