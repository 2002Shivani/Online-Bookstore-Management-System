package com.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.OrderDao;
import com.bookstore.entities.Order;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;

	public Order orderEntry(Order ord) {
		return dao.orderEntry(ord);
	}

	public List<Order> orderHistory() {

		return dao.orderHistory();
	}
}
