package com.shuzhai.service.Imp;

import com.shuzhai.controller.BookController;
import com.shuzhai.dao.BookDao;
import com.shuzhai.dao.BookPicDao;
import com.shuzhai.dao.GetBookDao;
import com.shuzhai.domain.Book;
import com.shuzhai.domain.BookPic;
import com.shuzhai.domain.Category;
import com.shuzhai.domain.Page;
import com.shuzhai.service.BookService;
import com.shuzhai.util.HandleFileUtil;
import com.shuzhai.util.HandlePathUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shuzhai
 * @description:
 * @author: Jay
 * @create: 2019-10-05 13:08
 **/

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookPicDao bookPicDao;
    @Autowired
    private GetBookDao getBookDao;


    /* 日志管理*/
    private static final Logger log = Logger.getLogger(BookServiceImp.class);


    public boolean addBook(Book book, List<MultipartFile> pictures){
        defaultValue(book);
        try{
            bookDao.addBook(book);
            log.info("添加 book 的信息" + book);
            uploadBookPics(book.getBookId(), pictures);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 设置图书默认值
    private void defaultValue(Book book){
        book.setInDate(new Timestamp(System.currentTimeMillis()));
        book.setAditStatus(1);
        book.setInSelling(1);
    }

    // 处理 book 图片上传路径，返回 上传的路径
    private void uploadBookPics(int bookID, List<MultipartFile> pictures){
        List<BookPic> bookPics = new ArrayList<>();

        for (MultipartFile pic : pictures){
            // 判断当前上传文件是否为空
            //if(pic.isEmpty())
                //continue;
            String storePath = HandlePathUtil.handlePicPath(pic.getOriginalFilename(), 1);
            BookPic bookPic = null;
            // 设置文件指定位置
            File disk = new File(storePath);
            log.info("disk的位置："+ disk.getAbsolutePath());
            try{
                // 将文件上传到指定位置
                FileUtils.copyInputStreamToFile(pic.getInputStream(), disk);
                // 存储图片的信息
                bookPic = new BookPic(bookID, 0, 1,storePath);
                log.info("上传图书的照片：" + bookPic);
            }catch(Exception e){
                e.printStackTrace();
            }
            if(bookPic != null)
                bookPics.add(bookPic);
        }
        // 设置第一张图片为主图
        bookPics.get(0).setIsMainPic(1);
        // 批量插入图片数据
        bookPicDao.addBookPics(bookPics);
    }


    /**
     *
     * @Author: jay
     * @Description: 处理上传一张图片
     * @Date 2019/10/18 12:54
     **/
    public BookPic uploadBookPic(Integer bookId, CommonsMultipartFile picture){
        String storePath = HandlePathUtil.handlePicPath(picture.getOriginalFilename(), 1);
        File file = new File(storePath);
        BookPic bookPic;
        try{
            FileUtils.copyInputStreamToFile(picture.getInputStream(), file);
            bookPic = new BookPic(bookId, 0, 1,storePath);
            bookPicDao.addBookPic(bookPic);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        bookPic.setPicPath(HandlePathUtil.storePathTransformUrl(storePath));
        return bookPic;
    }

    /**
     *
     * @Author: jay
     * @Description: 删除图书一张图片
     * @Date 2019/10/18 12:54
     **/
    public boolean deleteBookPicByBookPicId(Integer bookPicId){
       BookPic bookPic = null;
       String storePath = null;
       try {
           bookPic = bookPicDao.getBookPicByBookPicID(bookPicId);
           log.info("待删除的图片：" + bookPic);
           storePath = bookPic.getPicPath();
           bookPicDao.deletePicByPicId(bookPicId);
       }catch (Exception e){
           e.printStackTrace();
       }
       boolean flag = HandleFileUtil.deleteFileByStorePath(storePath);
       if(!flag)
           return false;

       return true;
    }

    /**
     *
     * @Author: jay
     * @Description: 获取图书分类信息
     * @Date 2019/10/20 11:56
     **/
    public List<Category> getCategoryInfo(){
        return bookDao.getCategoryInfo();
    }

    public Page<Book> getBooksByLatest(Integer pageNo, Integer pageSize){
        Page<Book> page = new Page<>();
        try{
            int count = getBookDao.getBooksCount();
            page.setTotalCount(count);
            // 必须先获取页面总数，才能设置 pageNo, 不然会报错的。
            page.setPageNo(pageNo);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        if(pageSize != null)
            page.setPageSize(pageSize);

        try{
            System.out.println(" index ：" + page.getIndex());
            List<Book> books =  getBookDao.getBooksByLatest(page.getIndex(), page.getPageSize());
            getBooksPicByBookID(books);
            page.setPageData(books);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return page;
    }

    private List<Book> getBooksPicByBookID(List<Book> books){
        for(Book book: books){
            try{
                List<BookPic> bookPics = bookPicDao.getBookPicsByBookID(book.getBookId());
                for(BookPic bookPic: bookPics) {
                    String url = HandlePathUtil.storePathTransformUrl(bookPic.getPicPath());
                    bookPic.setPicPath(url);
                    System.out.println(bookPic);
                }
                //System.out.println(bookPics.get(0));
                book.setBookPics(bookPics);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return books;
    }

    public List<Book> getPublishedBooksByUserId(Integer userId){
        List<Book> books = bookDao.getPublishedBooksByUserId(userId);
        if(books.isEmpty())
            return null;
        for(Book book: books){
            List<BookPic> bookPics = bookPicDao.getBookPicsByBookID(book.getBookId());
            book.setBookPics(bookPics);
        }
        return books;
    }

    public Page<Book> getBooksByCategory(Integer category, Integer pageNo, Integer pageSize){
        log.info("category:"+ category + "pageNo：" + pageNo + "pageSize：" + pageSize);
        Page<Book> page = new Page<>();
        try{
            // 设置获取书籍总数量
            Integer count = getBookDao.getBooksCountByCategory(category);
            page.setTotalCount(count);
            page.setPageNo(pageNo);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        if(pageSize != null)
            page.setPageSize(pageSize);

        try{
            List<Book> books = getBookDao.getBooksByCategory(page.getIndex(), page.getPageSize(), category);
            getBooksPicByBookID(books);
            page.setPageData(books);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return page;
    }


}
