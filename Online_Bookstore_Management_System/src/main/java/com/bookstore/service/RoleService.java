package com.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.RoleDao;
import com.bookstore.entities.Role;

@Service
public class RoleService {
	@Autowired
	RoleDao dao;

	public Role insertRole(Role role) {
		return dao.insertRole(role);
	}
	
	public List<Role> getAllRole(){
		return dao.getAllRole();
	}
	
	public Role getSpecificRole(String roleName){
		return dao.getSpecificRole(roleName);
	}
	
}
