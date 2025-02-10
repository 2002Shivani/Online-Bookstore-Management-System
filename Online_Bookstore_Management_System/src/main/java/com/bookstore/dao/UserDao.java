package com.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.dto.LoginRequest;
import com.bookstore.entities.Role;
import com.bookstore.entities.User;

@Repository
public class UserDao {

	@Autowired
	SessionFactory factory;

	User existUser = null;

	// User Insert
	public User userInsert(User user) {
		Session session = null;

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
		Session session = null;

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
		} finally {
			session.close();
		}
		return null;
	}

	// update user

	@SuppressWarnings("deprecation")
	public User userUpdate(User user) {
		Session session = null;

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
		} finally {
			session.close();
		}

	}

	// get all user
	public List<User> getAllUser() {
		Session session = null;

		List<User> record = null;
		try {

			session = factory.openSession();
			String hqlQuery = "from User";
			Query<User> query = session.createQuery(hqlQuery, User.class);
			record = query.getResultList();
			session.beginTransaction().commit();
			return record;

		} catch (Exception e) {

		} finally {
			session.close();
		}
		return record;
	}

	// get user by name

	public User getUserByEmail(String userEmail) {
		Session session = null;

		try {
			session = factory.openSession();
			existUser = session.get(User.class, userEmail);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return existUser;
	}

	// get specific role record

	public List<User> getSpecific(Role userRole) {
		List<User> record = null;
		Session session = null;

		try {
			session = factory.openSession();

			String hqlQuery = "from  User where userRole=:userRole";
			Query<User> query = session.createQuery(hqlQuery, User.class);
			query.setParameter("userRole", userRole);
			record = query.getResultList();
			session.beginTransaction().commit();
			return record;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return record;
	}
}
