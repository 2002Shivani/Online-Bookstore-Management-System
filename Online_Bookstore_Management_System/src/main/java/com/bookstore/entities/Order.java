package com.bookstore.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
@Table(name="Order_Database")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderDate;
	private String orderStatus;
	private double orderTotalAmount;
	private String custName;
	private Long custMobile;
	private int numberOfBookPurchase;
	
	@ManyToOne
	@JoinColumn(name="employeeName")
	private User employeeName;
	
	@ManyToOne
	@JoinColumn(name="purchase_book")
	private Book book;
	
	
}
