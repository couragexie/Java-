package action;

/*
 * ����ǰ������ͼ�����ݵ�����
 *
 *
 * */

import Dao.IOBookDao;
import Domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/ReadBooksServlet")
public class ReadBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("123");
        String url = request.getSession().getServletContext().getRealPath("/static/upload");
        System.out.println(url);


        // ��ȡ�����ͼ�����
        int classifyID = Integer.parseInt(request.getParameter("classifyID"));

        // ʵ���� IOBookDao �࣬�������ڴ����ȡ���ݿ�ͼ�������
        IOBookDao ioBookDao = new IOBookDao();

        // ���� ͼ����� list ���飬���ڴ洢ͼ���࣬
        ArrayList<Book> books = new ArrayList<>();

        // ��ȡ�������
        PrintWriter out = response.getWriter();

        // json �ַ�����������ҳ�����json��
        StringBuilder json1 = new StringBuilder();

        // ioBookDao ���� list ����
        books = ioBookDao.readBooks(classifyID);

        // �ж��Ƿ��ȡ�ɹ�����
        // �����������ַ���ƴ�ӳ� json ���ݵĸ�ʽ
        // ��ʵ�и��õĽ�����������������jar��������JSON����������
        if (books.size() != 0) {
            json1.append("{\"meg\":\"success\", ");
            json1.append("\"data\":{\"books\":[ ");
            for (Book book : books) {
                StringBuilder str = new StringBuilder();
                str.append("{ \"id\": " + "\"" + book.getId() + "\"");
                str.append(", \"bookName\":" + "\"" + book.getBookName() + "\"");
                str.append(", \"author\":" + "\"" + book.getAuthor() + "\"");
                str.append(", \"press\":" + "\"" + book.getPress() + "\"");
                str.append(", \"intro\":" + "\"" + book.getIntro() + "\"");
                str.append(", \"picture\":" + "\"" + book.getPicture() + "\"");
                str.append(", \"price\":" + "\"" + book.getPrice() + "\"");
                str.append("}#1");
                System.out.println(str);
                json1.append(str.toString());
            }
            // �����ַ���ƴ�����⣬
            int index = json1.lastIndexOf("#");
            json1.delete(index, json1.length());
            json1.append(" ] } }");
            String json = json1.toString();
            json = json.replaceAll("#1", ", ");
            System.out.println(json);

            // ��ǰ����� JSON ����
            out.println(json);

        } else {
            out.println("meg:false");
        }


    }


}
