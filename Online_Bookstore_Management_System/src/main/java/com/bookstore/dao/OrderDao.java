package com.bookstore.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bookstore.entities.Order;

@Repository
public class OrderDao {

	@Autowired
	SessionFactory factory;

	Order exOrder = null;

	public Order orderEntry(Order ord) {
		Session session = null;
		try {
			session = factory.openSession();
			session.persist(ord);
			session.beginTransaction().commit();
			return ord;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	public List<Order> orderHistory() {
		Session session = null;
		List<Order> order = null;
		try {
			session = factory.openSession();
			String hqlQ = "from Order";
			Query<Order> q = session.createQuery(hqlQ, Order.class);
			order = q.getResultList();
			session.beginTransaction().commit();
			return order;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return order;
	}

}
