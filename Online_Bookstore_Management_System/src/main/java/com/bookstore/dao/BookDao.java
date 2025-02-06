package com.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.Book;

@Repository
public class BookDao {

	@Autowired
	SessionFactory factory;
	Session session=null;
	Transaction tr = null;
	Book eBook = null;
	public Book insertBook(Book b) {
		try {
			session = factory.openSession();
			eBook  = session.get(Book.class, b.getBookTitle());
			if(eBook==null) {
				session.persist(b);
				session.beginTransaction().commit();
				return b;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Book> getAllBook() {
		List<Book> records = null;
		try {
			session = factory.openSession();
			String hql = "from Book";
			Query<Book> q = session.createQuery(hql, Book.class);
			records = q.getResultList();
			session.beginTransaction().commit();
			return records;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Book getBookByName(String bookTitle){
		try {
			session = factory.openSession();
			eBook = session.get(Book.class, bookTitle);
			session.beginTransaction().commit();
			return eBook;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deleteBook(String bookTitle) {
		try {
			session = factory.openSession();
			eBook = session.get(Book.class, bookTitle);
			session.remove(eBook);
			session.beginTransaction().commit();
			return "Deleted";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "NO BOOK Available Name:"+bookTitle;
	}
	
	public List<Book> getBookByAuthor(String bookAuthor) {
		List<Book> records = null;
		try {
			session = factory.openSession();
			String hql = "from Book where bookAuthor=:bookAuthor";
			Query<Book> q = session.createQuery(hql, Book.class);
			q.setParameter("bookAuthor", bookAuthor);
			records = q.getResultList();
			session.beginTransaction().commit();
			return records;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
