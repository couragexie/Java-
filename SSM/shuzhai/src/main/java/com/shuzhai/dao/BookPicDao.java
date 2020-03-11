package com.shuzhai.dao;

import com.shuzhai.domain.Book;
import com.shuzhai.domain.BookPic;

import java.util.List;

public interface BookPicDao {

    // 批量添加图片
    public void addBookPics(List<BookPic> bookpics);

    // 单个图片添加
    public void addBookPic(BookPic bookPic);

    // 通过 PicId 删除照片
    public void deletePicByPicId(Integer bookPicId);

    // 通过 BookId 删除照片
    public void deletePicsByBookId(Integer bookId);

    // 设置图片是否有效
    public void setPicInvaild(Integer picId);

    // 获取图书一组照片
    public List<BookPic> getBookPicsByBookID(Integer bookId);

    // 获取图书一张照片
    public BookPic getBookPicByBookPicID(Integer bookPicId);

}
