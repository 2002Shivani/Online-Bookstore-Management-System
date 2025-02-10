package com.bookstore.controller;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.dto.OrderDto;
import com.bookstore.entities.Book;
import com.bookstore.entities.Order;
import com.bookstore.entities.User;
import com.bookstore.service.BookService;
import com.bookstore.service.OrderService;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/bookstore/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	@Autowired
	SessionFactory factory;

	@SuppressWarnings("deprecation")
	@PostMapping("/orderEntry")
	public Order orderEntry(@RequestBody OrderDto order) {

		Book b = bookService.getBookByName(order.getBook());
		User u = userService.getUserByEmail(order.getEmployeeName());

		Order ord = new Order();

		b.setBookQuantity(b.getBookQuantity() - order.getNumberOfBookPurchase());

		int Quantity = b.getBookQuantity();
		if (Quantity == 0) {
			b.setInStock("Out of Stock");
		} else {
			b.setInStock("In Stock");
		}
		Session session = factory.openSession();
		session.update(b);
		session.beginTransaction().commit();

		ord.setOrderDate(order.getOrderDate());
		ord.setOrderStatus(order.getOrderStatus());
		ord.setOrderTotalAmount(b.getBookPrice());
		ord.setCustName(order.getCustName());
		ord.setCustMobile(order.getCustMobile());
		ord.setNumberOfBookPurchase(order.getNumberOfBookPurchase());
		ord.setBook(b);
		ord.setEmployeeName(u);
		return orderService.orderEntry(ord);
	}

	@GetMapping("/orderHistory")
	public List<Order> orderHistory() {
		return orderService.orderHistory();
	}
}
