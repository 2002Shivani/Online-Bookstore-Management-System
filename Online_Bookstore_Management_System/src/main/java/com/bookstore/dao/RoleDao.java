package com.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.Role;


@Repository
public class RoleDao {

	@Autowired
	SessionFactory factory;

	Role existingRole = null;

	public Role insertRole(Role role) {
		Session session = null;
		try {
			session = factory.openSession();
			existingRole = session.get(Role.class, role.getRoleName());
			if (existingRole == null) {
				session.persist(role);
				session.beginTransaction().commit();
				return role;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Role> getAllRole() {
		List<Role> role;
		Session session = null;
		try {
			session = factory.openSession();
			String hqlQuery = "from Role";
			Query<Role> query = session.createQuery(hqlQuery, Role.class);
			role = query.getResultList();
			session.beginTransaction().commit();
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public Role getSpecificRole(String roleName) {
		Role role = null;
		Session session = null;
		try {
			session = factory.openSession();
			role = session.get(Role.class, roleName);
//			String hqlQuery = "from  Role where roleName=:roleName";
//			Query<Role> query = session.createQuery(hqlQuery, Role.class);
//			query.setParameter("roleName", roleName);
//			role = query.getResultList();
			session.beginTransaction().commit();
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}

}
