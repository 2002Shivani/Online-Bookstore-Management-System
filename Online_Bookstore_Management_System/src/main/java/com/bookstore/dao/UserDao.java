package com.bookstore.dao;

import java.util.HashSet;
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
			
				session.persist(user);
				session.beginTransaction().commit();
				return user;

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

	public User userUpdate(User user, String email) {
		try {
			session = factory.openSession();
			existUser = session.get(User.class, email);
			existUser.setUserCity(user.getUserCity());
			existUser.setUserPhone(user.getUserPhone());
			session.merge(user);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	// get all user
	public Set<User> getAllUser() {
		Set<User> record = new HashSet<User>();
		try {

			session = factory.openSession();
			String hqlQuery = "from User";
			Query<User> query = session.createQuery(hqlQuery, User.class);
			record = (Set<User>) query.getResultList();

		} catch (Exception e) {

		} finally {
			session.close();
		}
		return record;
	}

	// get user by name

	public User getUserByEmail(String email) {
		try {
			session = factory.openSession();
			existUser = session.get(User.class, email);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return existUser;
	}

	// get specific role record

	public Set<User> getSpecific(String role) {
		Set<User> record = new HashSet<User>();

		try {
			session = factory.openSession();
			if (role.toLowerCase().equals("admin")) {
				String hqlQuery = "from  User where userRoles=:role";
				Query<User> query = session.createQuery(hqlQuery, User.class);
				query.setParameter(" userRoles", role);
				query.executeUpdate();
				session.beginTransaction().commit();
				return record;
			} else if (role.toLowerCase().equals("customer")) {
				String hqlQuery = "from  User where userRoles=:role";
				Query<User> query = session.createQuery(hqlQuery, User.class);
				query.setParameter(" userRoles", role);
				query.executeUpdate();
				session.beginTransaction().commit();
				return record;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}
}
