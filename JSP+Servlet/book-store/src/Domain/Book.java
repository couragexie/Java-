package Domain;

public class Book {
    private int id;
    private int classify;
    private String bookName;
    private String author;
    private String press;
    private String intro;
    private String picture;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[  id: " + id);
        str.append("    ���ࣺ" + classify);
        str.append("    ������" + bookName);
        str.append("    ���ߣ�" + author);
        str.append("    �����磺" + press);
        str.append("    ��飺" + intro);
        str.append("    ��Ƭ��" + picture);
        str.append("    �۸�" + price);

        str.append(" ]");
        return str.toString();
    }

}
