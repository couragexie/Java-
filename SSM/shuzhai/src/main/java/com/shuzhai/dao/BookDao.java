package com.shuzhai.dao;

import com.shuzhai.domain.Book;
import com.shuzhai.domain.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: shuzhai
 * @description: BookDao
 * @author: Jay
 * @create: 2019-10-05 13:57
 **/

public interface BookDao {

    // 添加图书
    public void addBook(Book book);

    // 更新图书信息
    public void updateBook();

    // 删除图书信息
    public void deleteBook();

    // 获取用户发布的书籍
    public List<Book> getPublishedBooksByUserId(Integer useId);

    // 获取图书分类信息
    public List<Category> getCategoryInfo();

}
