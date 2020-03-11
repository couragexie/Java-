package com.shuzhai.service.Imp;

import com.shuzhai.domain.Book;
import com.shuzhai.domain.Page;
import com.shuzhai.service.BookService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImpTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

    @Test
    public void getBooksByLatest() {
        BookService bookService = ioc.getBean(BookService.class);

        Page<Book> page =  bookService.getBooksByLatest(1,3);
        List<Book> books = page.getPageData();
        for(Book book: books){
            System.out.println(book);
            System.out.println(book.getBookPics());
        }

    }
}