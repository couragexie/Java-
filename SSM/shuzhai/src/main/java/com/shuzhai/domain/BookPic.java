package com.shuzhai.domain;

public class BookPic {

    private int bookPicID;

    private int bookId; // 图片所属图书id

    private int isMainPic; // 是否为主图

    private int picStatus; // 图片是否有效

    private String picPath;  // 图片存储路径

    public BookPic(){}

    public BookPic(int bookId,  int isMainPic, int picStatus, String picPath) {
        this.bookId = bookId;
        this.isMainPic = isMainPic;
        this.picStatus = picStatus;
        this.picPath = picPath;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public String toString() {
        return "BookPic{" +
                "bookPicID=" + bookPicID +
                ", bookId=" + bookId +
                ", isMainPic=" + isMainPic +
                ", picStatus=" + picStatus +
                ", picPath=" + picPath +
                '}';
    }

    public int getBookPicID() {
        return bookPicID;
    }

    public void setBookPicID(int bookPicID) {
        this.bookPicID = bookPicID;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getIsMainPic() {
        return isMainPic;
    }

    public void setIsMainPic(int isMainPic) {
        this.isMainPic = isMainPic;
    }

    public int getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(int picStatus) {
        this.picStatus = picStatus;
    }
}
