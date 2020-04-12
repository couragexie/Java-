package action;

/*
 * �����û�ע�����
 * */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Domain.User;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        UserDao uDao = new UserDao();


        String tel = request.getParameter("telephone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        user.setUserName(username);
        user.setPassword(password);
        user.setTelephone(tel);

        int ok = uDao.registration(user);
        if (ok != -1) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            System.out.println("ע��ʧ��");
            request.setAttribute("msg", "ע��ʧ�ܣ��û�����ע��!");
            request.getRequestDispatcher("register.jsp").forward(request, response);

        }

    }

}
