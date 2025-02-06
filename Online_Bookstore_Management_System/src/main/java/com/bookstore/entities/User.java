package com.bookstore.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	
	@ManyToOne
	@JoinColumn(name="userRole")
	private Role userRole;
	


	
	
}
