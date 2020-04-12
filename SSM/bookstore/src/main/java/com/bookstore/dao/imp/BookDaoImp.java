package com.bookstore.dao.imp;

import com.bookstore.dao.BaseDao;
import com.bookstore.dao.BookDao;
import com.bookstore.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository()
public class BookDaoImp extends BaseDao<Book> implements BookDao {

    @Override
    public Book getBook(Integer id) {
        String sql = "SELECT * FROM book Where id=?";
        return this.get(sql, id);
    }

    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO book(bookName, author, price, press, classifyID, intro, stock, imgPath) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        return this.update(sql, book.getBookName(), book.getAuthor(), book.getPrice(),
                book.getPress(), book.getClassifyID(),
                book.getIntro(), book.getStock(), book.getImgPath());
    }

    @Override
    public List<Book> getAllBook(Integer classifyID) {
        String sql = "SELECT * FROM book where classifyID=?";
        return this.getList(sql, classifyID);
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "DELETE FROM book WHERE id=?";
        return this.update(sql, id);
    }


    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE book SET bookName=?, author=?, price=?," +
                "press=?, classifyID=?, intro=?, stock=?, imgPath=? WHERE id=?";
        return this.update(sql, book.getBookName(), book.getAuthor(), book.getPrice(),
                book.getPress(), book.getClassifyID(), book.getIntro(),
                book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int updateStock(Integer id, Integer stock) {
        String sql = "UPDATE book SET stock=? WHERE id=?";
        return this.update(sql, stock, id);
    }
}
