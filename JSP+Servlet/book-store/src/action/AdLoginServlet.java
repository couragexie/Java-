package action;
/*
* 处理管理员验证登录
* 本来可以和 LoginServlet 合成同一个类，只是不知道如何验证是普通用户的form表单
* 或者是管理员的 form 表单，所以用了两个类来处理
* */


import Util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/AdLoginServlet")
public class AdLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文乱码问题
//        response.setContentType("text/plain; charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if(action == null){
            login(request, response);
        }else{
            logout(request, response);
        }


    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("adusername");
        request.getSession().invalidate();
        response.sendRedirect("backLogin.jsp");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection con;
        PreparedStatement preSt;
        ResultSet rs;
        con = DBConnection.connectDB();
        String sql = "SELECT * FROM administrator WHERE username=?";

        try{
            preSt = con.prepareStatement(sql);
            preSt.setString(1,username);
            rs = preSt.executeQuery();

            if(rs.next()){
                if(rs.getString(2).equals(password)) {
                    request.getSession().setAttribute("adUsername",username);
                    response.sendRedirect("backIndex.jsp");
                }
            }

            request.setAttribute("msg", "登录失败，密码或账号错误!");
            request.getRequestDispatcher("backLogin.jsp").forward(request,response);

        }catch(Exception e){
            System.out.println(e);
        }


    }



}
