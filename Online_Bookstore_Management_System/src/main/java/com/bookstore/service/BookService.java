package com.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookDao;
import com.bookstore.entities.Book;

@Service
public class BookService {

	@Autowired
	BookDao dao;

	public Book insertBook(Book b) {

		return dao.insertBook(b);
	}

	public List<Book> getAllBook() {

		return dao.getAllBook();
	}

	public Book getBookByName(String bookTitle) {

		return dao.getBookByName(bookTitle);
	}

	public String deleteBook(String bookTitle) {
		String msg = dao.deleteBook(bookTitle);
		return msg;
	}

	public List<Book> getBookByAuthor(String bookAuthor) {
		return dao.getBookByAuthor(bookAuthor);
	}

}
