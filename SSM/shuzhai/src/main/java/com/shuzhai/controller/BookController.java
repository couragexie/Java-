package com.shuzhai.controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.shuzhai.domain.*;
import com.shuzhai.service.Imp.BookServiceImp;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.w3c.dom.stylesheets.LinkStyle;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

@RequestMapping("/book")
@RestController
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    BookServiceImp bookService;

    /** Log4j日志处理(@author: rico) */
    private static final Logger log = Logger.getLogger(BookController.class);

    /**
     *
     * @Author: jay
     * @Description: 获取用户发布的书籍
     * @Date 2019/10/17 9:26
     **/
    @RequestMapping(value = "publishedBooks", method = RequestMethod.GET)
    public Response getPubBook(Integer userId){
        List<Book> books = bookService.getPublishedBooksByUserId(userId);
        if(books == null)
            return new Response().failure("尚未发布书籍");
        return new Response().success(books);
    }


    /**
     *
     * @Author: jay
     * @Description:  发布书籍
     * @Date 2019/10/18 22:09
     **/
    @RequestMapping(method = RequestMethod.POST)
    public Response uploadBookPics(Book book, MultipartRequest request,
                                    @RequestParam Double price){
        List<MultipartFile> pics = new ArrayList<>();
        log.info("获取数据111：" + book + " 价格：" + price);
        // 设置图书金额
        if(price != null)
            book.setPrice(new BigDecimal(price));


        StringBuilder stringBuilder  = new StringBuilder();

        // 获取文件变量名
        Iterator<String> picsName = request.getFileNames();

        // 获取 MultipartRequest 文件
        while (picsName.hasNext()) {
            MultipartFile file = request.getFile(picsName.next());
            log.info("收到图片：" + file.getOriginalFilename());
            pics.add(file);
        }

        boolean ok = bookService.addBook(book, pics);

        if(!ok)
            return new Response().failure();
        return new Response().success();


    }

    /**
     * @Author: jay
     * @Description: 获取分类信息
     * @Date 2019/10/20 14:59
     **/
    @RequestMapping(value = "categoryInfo", method = RequestMethod.GET)
    public Response getBooksByCategory(){
        List<Category> categories = bookService.getCategoryInfo();
        return new Response().success(categories);
    }


    @RequestMapping(value = "latestBook", method = RequestMethod.GET)
    public Response getBooksByLast(Integer pageNo, Integer pageSize){
        log.info("pageNo：" + pageNo + " pageSize：" + pageSize);
        Page<Book> page = bookService.getBooksByLatest(pageNo, pageSize);
        if (page == null )
            return new Response().failure();
        return new Response().success(page);
    }

    @RequestMapping(value = "classifiedBook" , method = RequestMethod.GET)
    public Response getBooksByCategory(Integer category, Integer pageNo, Integer pageSize){
        log.info("category:"+ category + " pageNo：" + pageNo + " pageSize：" + pageSize);
        Page<Book> page = bookService.getBooksByCategory(category, pageNo, pageSize);
        if(page == null)
            return new Response().failure();
        return new Response().success(page);
    }

}
