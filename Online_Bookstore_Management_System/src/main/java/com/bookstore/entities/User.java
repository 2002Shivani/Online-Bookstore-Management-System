package com.bookstore.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User_Database")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
public class User {

	@Id
	private String userEmail;
	private String userName;
	private String userPassword;
	private String userCity;
	private long userPhone;
	private String userRoles;
	
	@ManyToMany
	@JoinTable(
			name="user_roles",
			joinColumns = @JoinColumn(name="userEmail"),
			inverseJoinColumns = @JoinColumn(name="roleId")
			)
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToMany(mappedBy = "user")
	private Set<Order> orders = new HashSet<Order>();
	
	@OneToOne(mappedBy = "user")
	private Cart cart;

	
	
}
