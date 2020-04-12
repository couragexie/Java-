package action;
/*
 * �������Ա��֤��¼
 * �������Ժ� LoginServlet �ϳ�ͬһ���ֻ࣬�ǲ�֪�������֤����ͨ�û���form��
 * �����ǹ���Ա�� form ������������������������
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
        // ����������������
//        response.setContentType("text/plain; charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            login(request, response);
        } else {
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

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection con;
        PreparedStatement preSt;
        ResultSet rs;
        con = DBConnection.connectDB();
        String sql = "SELECT * FROM administrator WHERE username=?";

        try {
            preSt = con.prepareStatement(sql);
            preSt.setString(1, username);
            rs = preSt.executeQuery();

            if (rs.next()) {
                if (rs.getString(2).equals(password)) {
                    request.getSession().setAttribute("adUsername", username);
                    response.sendRedirect("backIndex.jsp");
                }
            }

            request.setAttribute("msg", "��¼ʧ�ܣ�������˺Ŵ���!");
            request.getRequestDispatcher("backLogin.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
