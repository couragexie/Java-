package com.bookstore.dao;

import com.bookstore.domain.Book;

import java.util.List;

public interface BookDao {

    Book getBook(Integer id);

    int addBook(Book book);

    List<Book> getAllBook(Integer classifyID);

    int deleteBook(Integer id);

    int updateBook(Book book);

    int updateStock(Integer id, Integer stock);
}
