package com.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;
import com.bookstore.util.UUIDutil;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Map<String, Object> getAllBooks(Integer classifyID) {
        //System.out.println("前端获取 book 数据: " + classifyID);
        List<Book> books = this.handleImgsName(bookService.getBooks(classifyID));
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meg", "success");
        dataMap.put("books", books);
        return dataMap;
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView addBook(Book book, @RequestParam("picture") CommonsMultipartFile pictureFile) {
        String imgPath = handleImgPath(pictureFile.getOriginalFilename());
        System.out.println(pictureFile.getName());
        ModelAndView mv = new ModelAndView();
        try {
            pictureFile.transferTo(new File(imgPath));
            book.setImgPath(imgPath);
            bookService.addBook(book);
            mv.addObject("msg", "添加成功！！！");
        } catch (Exception e) {
            System.out.println("添加失败，失败原因：" + e);
            mv.addObject("msg", "添加失败！！！");
        }
        mv.setViewName("backIndex");
        return mv;
    }

    private String handleImgPath(String fileName) {
        String storePath = "D:\\DevelopmentTools\\img";
        File file = new File(storePath);
        //System.out.println(file.getAbsolutePath());
        String newFileName = UUIDutil.getUUID(fileName);
        //System.out.println(newFileName);
        String imgPath = storePath + "\\" + newFileName;

        return imgPath;
    }

    private String getImgName(String imgPath) {
        int index = imgPath.lastIndexOf("\\");
        //System.out.println(imgPath);
        String imgName = imgPath.substring(index + 1);
        //System.out.println(imgName);
        return imgName;
    }

    private List<Book> handleImgsName(List<Book> books) {
        for (Book book : books) {
            book.setImgName(this.getImgName(book.getImgPath()));
            book.setImgPath(" ");
        }
        return books;
    }

}
