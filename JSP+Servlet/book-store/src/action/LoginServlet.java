package action;

/*
 * ��ͨ�û���¼��֤
 * */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Domain.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private User user;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/plain; charset=UTF-8");

        System.out.println("����doPost��");
        String action = null;
        action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            System.out.println("login");
            login(request, response);
        } else {
            System.out.println("logOut");
            logOut(request, response);
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        user = new User();
        user.setUserName(username);
        user.setPassword(password);
        UserDao uDao = new UserDao();
        id = uDao.login(user);
        if (id != -1) {
            System.out.println("��¼�ɹ�");
            user.setId(id);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userID", id);
            session.setAttribute("username", user.getUserName());
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("��¼ʧ��");
            request.setAttribute("msg", "��¼ʧ�ܣ��˺š��������");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("userID");
//		response.sendRedirect("index.jsp");
        session.invalidate();
        PrintWriter out = response.getWriter();
        out.println("200");
    }
}
