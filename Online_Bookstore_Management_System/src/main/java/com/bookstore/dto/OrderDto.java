package com.bookstore.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private int orderId;
	private String orderDate;
	private String orderStatus;
	private double orderTotalAmount;
	private String custName;
	private Long custMobile;
	private int numberOfBookPurchase;
	private String EmployeeName;
	private String book;
}
