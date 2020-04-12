package Dao;

import Domain.Book;
import Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IOBookDao {

    private static Connection con;
    private static PreparedStatement preSt;
    private static ResultSet rs;


    // ��ȡ���ݿ���Ϣ
    public ArrayList<Book> readBooks(int classifyID) {
        String sql = "SELECT * FROM books where classifyID=?";
        ArrayList<Book> books = new ArrayList<>();
        con = DBConnection.connectDB();

        try {
            preSt = con.prepareStatement(sql);
            preSt.setInt(1, classifyID);
            rs = preSt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setClassify(rs.getInt(2));
                book.setBookName(rs.getString(3));
                book.setPrice(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setPress(rs.getString(6));
                book.setIntro(rs.getString(7));

                String picture = rs.getString(8);
                if (picture != null) {
                    int index = picture.lastIndexOf("\\");
                    picture = picture.substring(index + 1);
                }
                System.out.println(picture);
                book.setPicture(picture);

                System.out.println(book);
                books.add(book);
            }

            System.out.println();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return books;
    }


    // �����ݿ�д��ͼ����Ϣ
    public int storeBook(Book book) {
        con = DBConnection.connectDB();
        String sql = "INSERT INTO books (classifyID, name, price, author, press, intro, picture) values (?, ?, ?, ? ,?, ?, ?)";

        try {
            preSt = con.prepareStatement(sql);
            preSt.setInt(1, book.getClassify());
            preSt.setString(2, book.getBookName());
            preSt.setString(3, book.getPrice());
            preSt.setString(4, book.getAuthor());
            preSt.setString(5, book.getPress());
            preSt.setString(6, book.getIntro());
            preSt.setString(7, book.getPicture());

            int ok = preSt.executeUpdate();

            return ok;
        } catch (Exception e) {

        } finally {
            try {
                rs.close();
                preSt.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }


}
