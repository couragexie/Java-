package com.shuzhai.dao;

import com.shuzhai.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GetBookDao {
    // 获取图书
    public Book getBook(int BookID);

    // 分页查询, 获取当前最新发布的，index 为起始索引
    public List<Book> getBooksByLatest(@Param("index") int index, @Param("pageSize") int pageSize);

    // 根据图书分类获取图书
    public List<Book> getBooksByCategory(@Param("index") int index,
                                         @Param("pageSize") int pageSize,
                                         @Param("category") int category);

    // 获取全部图书
    public List<Book> getAllBooks();

    // 获取全部图书数量
    public int getBooksCount();

    // 获取某一分类图书数量
    public int getBooksCountByCategory(int category);


}
