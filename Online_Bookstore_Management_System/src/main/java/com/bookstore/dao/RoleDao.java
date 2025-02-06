package com.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.Role;
import com.bookstore.entities.User;

@Repository
public class RoleDao {
	
	@Autowired
	SessionFactory factory;
	Session session = null;
	Role existingRole = null;
	
	
	public Role insertRole(Role role) {
		try {
			session = factory.openSession();
			existingRole = session.get(Role.class,role.getRoleName());
			if(existingRole==null) {
				session.persist(role);
				session.beginTransaction().commit();
				return role;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Role> getAllRole(){
		List<Role> role;
		try {
			session = factory.openSession();
			String hqlQuery = "from Role";
			Query<Role> query = session.createQuery(hqlQuery, Role.class);
			role = query.getResultList();
			session.beginTransaction().commit();
			return role;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Role getSpecificRole(String roleName){
		Role role = null;
		try {
			session = factory.openSession();
			role = session.get(Role.class, roleName);
//			String hqlQuery = "from  Role where roleName=:roleName";
//			Query<Role> query = session.createQuery(hqlQuery, Role.class);
//			query.setParameter("roleName", roleName);
//			role = query.getResultList();
			session.beginTransaction().commit();
			return role;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return role;
	}
	
	
	
	

}
