package com.shuzhai.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Book {

    private int bookId;  // 图书 id

    private String bookName; //

    private String category;  // 分类

    private BigDecimal price;   // 价格

    private String author;  // 作者

    private String bookIntro; // 介绍

    private String pubRegion;  // 发布地点

    private Timestamp inDate;  // 录入时间

    private int inSelling; // 是否在销售，1：正在销售

    private int aditStatus;  // 审核状态

    private int userId; // 发布人的id

    private int likeNum;   // 点赞数量

    private int collect;    // 收藏人数

    private String tradingway;   // 交易方式

    private List<BookPic> bookPics;  // 图书图片

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", bookIntro='" + bookIntro + '\'' +
                ", pubRegion='" + pubRegion + '\'' +
                ", inDate=" + inDate +
                ", inSelling=" + inSelling +
                ", aditStatus=" + aditStatus +
                ", userId=" + userId +
                ", likeNum=" + likeNum +
                ", collect=" + collect +
                ", tradingway='" + tradingway + '\'' +
                '}';
    }

    public String getTradingway() {
        return tradingway;
    }

    public void setTradingway(String tradingway) {
        this.tradingway = tradingway;
    }

    public String getPubRegion() {
        return pubRegion;
    }

    public void setPubRegion(String pubRegion) {
        this.pubRegion = pubRegion;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    public int getInSelling() {
        return inSelling;
    }

    public void setInSelling(int inSelling) {
        this.inSelling = inSelling;
    }

    public int getAditStatus() {
        return aditStatus;
    }

    public void setAditStatus(int aditStatus) {
        this.aditStatus = aditStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<BookPic> getBookPics() {
        return bookPics;
    }

    public void setBookPics(List<BookPic> bookPics) {
        this.bookPics = bookPics;
    }
}
