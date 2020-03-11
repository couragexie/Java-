package com.shuzhai.service;

import com.shuzhai.domain.Book;
import com.shuzhai.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface BookService {

    public boolean addBook(Book book, List<MultipartFile> pictures);

    public Page<Book> getBooksByLatest(Integer pageNo, Integer pageSize);
}
