
package com.bookstore.domain;
import java.io.Serializable;

public class Book  {
    private Integer id;
    private String bookName;
    private String author;
    private Double price;
    private String press;
    private Integer classifyID;
    private String intro;
    private Integer stock;
    private String imgPath;
    private String imgName;

    public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Book(){}

    public Book(String bookName, String author, Double price, String press, Integer classifyID, String intro, Integer stock, String imgPath) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.press = press;
        this.classifyID = classifyID;
        this.intro = intro;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getClassifyID() {
        return classifyID;
    }

    public void setClassifyID(Integer classifyID) {
        this.classifyID = classifyID;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", classifyID=" + classifyID +
                ", intro='" + intro + '\'' +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
