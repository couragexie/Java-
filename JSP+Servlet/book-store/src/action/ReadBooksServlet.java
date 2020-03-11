package action;

/*
* 处理前端请求图书数据的请求
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
public class ReadBooksServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("123");
        String url = request.getSession().getServletContext().getRealPath("/static/upload");
        System.out.println(url);


        // 获取请求的图书分类
        int classifyID = Integer.parseInt(request.getParameter("classifyID"));

        // 实例化 IOBookDao 类，该类用于处理读取数据库图书的数据
        IOBookDao ioBookDao = new IOBookDao();

        // 定于 图书类的 list 数组，用于存储图书类，
        ArrayList<Book> books = new ArrayList<>();

        // 获取输出对象
        PrintWriter out = response.getWriter();

        // json 字符串，用于向页面输出json，
        StringBuilder json1 = new StringBuilder();

        // ioBookDao 返回 list 数组
        books = ioBookDao.readBooks(classifyID);

        // 判断是否读取成功数据
        // 下面是利用字符串拼接成 json 数据的格式
        // 其实有更好的解决方法，引入第三方jar包，定义JSON对象来处理
        if(books.size() != 0){
            json1.append("{\"meg\":\"success\", ");
            json1.append("\"data\":{\"books\":[ ");
            for(Book book: books) {
                StringBuilder str = new StringBuilder();
                str.append("{ \"id\": " + "\""+ book.getId() + "\"");
                str.append(", \"bookName\":" + "\""+ book.getBookName()+ "\"");
                str.append(", \"author\":" + "\"" + book.getAuthor() + "\"");
                str.append(", \"press\":" + "\"" + book.getPress() + "\"");
                str.append(", \"intro\":" + "\"" + book.getIntro()+ "\"");
                str.append(", \"picture\":" + "\"" + book.getPicture()+ "\"");
                str.append(", \"price\":"+ "\"" + book.getPrice()+ "\"");
                str.append("}#1");
                System.out.println(str);
                json1.append(str.toString());
            }
            // 处理字符串拼接问题，
            int index = json1.lastIndexOf("#");
            json1.delete(index,json1.length());
            json1.append(" ] } }");
            String json = json1.toString();
            json = json.replaceAll("#1",", ");
            System.out.println(json);

            // 向前端输出 JSON 数据
            out.println(json);

        }else{
            out.println("meg:false");
        }


    }


}
