package com.bookstore.dto;

import java.util.List;

import com.bookstore.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
	
	private String roleName;

}
