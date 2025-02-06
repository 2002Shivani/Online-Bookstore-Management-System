package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dao.BookDao;
import com.bookstore.entities.Book;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/bookstore/book")
public class BookController {

	@Autowired
	BookService service;
	
	@PostMapping("/insertBook")
	public Book insertBook(@RequestBody Book b) {
		return service.insertBook(b);
	}
	
	@GetMapping("/getAllBook")
	public List<Book> getAllBook() {
		return service.getAllBook();
	}
	
	@GetMapping("/getBookByName")
	public Book getBookByName(@RequestParam String bookTitle){
		return service.getBookByName(bookTitle);
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestParam String bookTitle) {
		String msg = service.deleteBook(bookTitle);
		return msg;
	}
	
	@GetMapping("/getBookByAuthor")
	public List<Book> getBookByAuthor(@RequestParam String bookAuthor) {
		return service.getBookByAuthor(bookAuthor);
	}
}
