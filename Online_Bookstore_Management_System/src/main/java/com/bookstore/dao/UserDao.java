package com.bookstore.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.User;
import com.bookstore.model.LoginRequest;

@Repository
public class UserDao {

	@Autowired
	SessionFactory factory;
	Session session = null;
	Transaction tran = null;
	User existUser = null;

	// User Insert
	public User userInsert(User user) {

		try {

			session = factory.openSession();
			existUser = session.get(User.class, user.getUserEmail());
			if (existUser == null) {
				session.persist(user);
				session.beginTransaction().commit();
				return user;
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	// User Login

	public User userLogin(LoginRequest loginRequest) {
		try {
			session = factory.openSession();
			existUser = session.get(User.class, loginRequest.getUserEmail());
			if (existUser != null) {
				if (existUser.getUserPassword().equals(loginRequest.getUserPassword())) {
					return existUser;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// update user

	public User userUpdate(User user) {
		try {
			session = factory.openSession();
			existUser = session.get(User.class, user.getUserEmail());
			existUser.setUserCity(user.getUserCity());
			existUser.setUserPhone(user.getUserPhone());
			session.update(existUser);
			session.beginTransaction().commit();
			return existUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	
	}

	// get all user
	public List<User> getAllUser() {
		List<User> record =null;
		try {

			session = factory.openSession();
			String hqlQuery = "from User";
			Query<User> query = session.createQuery(hqlQuery, User.class);
			record = query.getResultList();
			session.beginTransaction().commit();
			return record;

		} catch (Exception e) {

		} finally {
			
		}
		return record;
	}

	// get user by name

	public User getUserByEmail(String userEmail) {
		try {
			session = factory.openSession();
			existUser = session.get(User.class, userEmail);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return existUser;
	}

	// get specific role record

	public List<User> getSpecific(String userRoles) {
		List<User> record = null;

		try {
			session = factory.openSession();
			if (userRoles.toLowerCase().equals("admin")) {
				String hqlQuery = "from  User where userRoles=:userRoles";
				Query<User> query = session.createQuery(hqlQuery, User.class);
				query.setParameter("userRoles", userRoles);
				record = query.getResultList();
				session.beginTransaction().commit();
				return record;
				
			} else if (userRoles.toLowerCase().equals("customer")) {
				String hqlQuery = "from  User where userRoles=:userRoles";
				Query<User> query = session.createQuery(hqlQuery, User.class);
				query.setParameter("userRoles", userRoles);
				record = query.getResultList();
				session.beginTransaction().commit();
				return record;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return record;
	}
}
