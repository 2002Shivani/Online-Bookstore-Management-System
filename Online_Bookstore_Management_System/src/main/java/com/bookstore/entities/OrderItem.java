package com.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="OrderItem_database")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	private int orderQuantity;
	private String orderBook;
	private double price;
	
	@ManyToOne
	@JoinColumn(name ="orderItem")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="bookId")
	private Book book;
	
	
	
}
