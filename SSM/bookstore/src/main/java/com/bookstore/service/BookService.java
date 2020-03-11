package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookDao;
import com.bookstore.domain.Book;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	public List<Book> getBooks(Integer classifyID){
		return bookDao.getAllBook(classifyID);	
	}
	
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	
}
