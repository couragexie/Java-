package com.manage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage.dao.CourseDao;
import com.manage.domain.StudentCourse;

/**
 * Servlet implementation class ChooseCourseServlet
 */
@WebServlet("/ChooseCourseServlet")
public class ChooseCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action.equals("choose")) {
            choose(request, response);

        } else if (action.equals("giveup")) {
            delChoose(request, response);
        }

    }

    private void choose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        CourseDao cDao = new CourseDao();
        StudentCourse sc = new StudentCourse();
        sc.setCid(request.getParameter("cid"));
        sc.setSid(request.getParameter("sid"));
        HttpSession session = request.getSession();

        boolean ok = cDao.chooseCourese(sc);

        if (ok) {
            //�������ѧ��ѡ����Ϣ
            session.setAttribute("StudentCourses", cDao.getCourseBySid(sc.getSid()));
            // �������ѧ����ѡ�γ���Ϣ
            session.setAttribute("chooseCourse", cDao.getChooseCourse(sc.getSid()));
            session.setAttribute("msg", "ѡ�γɹ���");
            session.setAttribute("path", "StudentIndex.jsp");
            response.sendRedirect(path + "/information.jsp");
        } else {
            session.setAttribute("msg", "ѡ��ʧ�ܣ�");
            session.setAttribute("path", "StudentIndex.jsp");
            response.sendRedirect(path + "/information.jsp");
        }

    }

    private void delChoose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        CourseDao cDao = new CourseDao();
        StudentCourse sc = new StudentCourse();
        sc.setCid(request.getParameter("cid"));
        sc.setSid(request.getParameter("sid"));
        HttpSession session = request.getSession();

        boolean ok = cDao.delChooseCourese(sc);
        if (ok) {
            //�������ѧ��ѡ����Ϣ
            session.setAttribute("StudentCourses", cDao.getCourseBySid(sc.getSid()));
            // �������ѧ����ѡ�γ���Ϣ
            session.setAttribute("chooseCourse", cDao.getChooseCourse(sc.getSid()));
            session.setAttribute("msg", "��ѡ�ɹ���");
            session.setAttribute("path", "StudentIndex.jsp");
            response.sendRedirect(path + "/information.jsp");
        } else {
            session.setAttribute("msg", "��ѡʧ�ܣ�");
            session.setAttribute("path", "StudentIndex.jsp");
            response.sendRedirect(path + "/information.jsp");
        }
    }
}
