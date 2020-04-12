package com.manage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage.dao.CourseDao;
import com.manage.dao.StudentDao;
import com.manage.domain.Course;
import com.manage.domain.Student;
import com.manage.domain.StudentCourse;
import com.manage.domain.StudentInfo;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
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
        //doGet(request, response);
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("modifyPw"))
            modifyPw(request, response);
        else if (action.equals("modifyInfo"))
            modifyInfo(request, response);
        else if (action.equals("addCourse"))
            addCourse(request, response);
        else if (action.equals("delCourse"))
            delCourse(request, response);
        else if (action.equals("modifyGrade"))
            modifyGrade(request, response);


    }

    private void modifyPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String path = request.getContextPath();
        StudentDao studentDao = new StudentDao();
        String password = request.getParameter("newPassword");
        String rePassword = request.getParameter("rePassword");
        if (!password.equals(rePassword)) {
            session.setAttribute("msg", "�޸�ʧ�ܣ�");
            session.setAttribute("path", "StudentIndex.jsp");
            response.sendRedirect(path + "/information.jsp");
            return;
        }
        String sid = request.getParameter("sid");

        Student student = new Student();
        student.setsId(sid);
        student.setPassword(password);
        boolean ok = studentDao.modifyPw(student);
        if (ok) {
            session.invalidate();
            session.setAttribute("msg", "�޸ĳɹ��������µ�¼");
            session.setAttribute("path", "login.jsp");
            response.sendRedirect(path + "/information.jsp");
        } else {
            session.setAttribute("msg", "�޸�ʧ�ܣ�");
            session.setAttribute("path", "StudentIndex.jsp");
            response.sendRedirect(path + "/information.jsp");
        }
    }

    private void modifyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo sInfo = new StudentInfo();
        sInfo.setsId(request.getParameter("sid"));
        sInfo.setAge(Integer.parseInt(request.getParameter("age")));
        sInfo.setClass_(Integer.parseInt(request.getParameter("class_")));
        sInfo.setName(request.getParameter("name"));
        sInfo.setMajor(request.getParameter("major"));
        sInfo.setSex(request.getParameter("sex"));
        sInfo.setPosition(request.getParameter("position"));
        sInfo.setPhoneNum(request.getParameter("phoneNum"));
        sInfo.setEmail(request.getParameter("email"));

        System.out.println(sInfo);
        HttpSession session = request.getSession();
        String path = request.getContextPath();
        StudentDao sDao = new StudentDao();
        boolean ok = sDao.modifyInfo(sInfo);
        if (ok) {
            session.setAttribute("students", sDao.getAllStudent());
            session.setAttribute("msg", "���³ɹ�");

        } else {
            session.setAttribute("msg", "����ʧ��");
            //request.setAttribute("", o);
        }
        request.setAttribute("sid", sInfo.getsId());
        session.setAttribute("path", "Fixinformation.jsp");
        response.sendRedirect(path + "/information.jsp");
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course = new Course();
        course.setCname(request.getParameter("cname"));
        course.setCid(request.getParameter("cid"));
        course.setCredit(Integer.parseInt(request.getParameter("credit")));

        CourseDao cDao = new CourseDao();

        boolean ok = cDao.addCourse(course);
        HttpSession session = request.getSession();
        String path = request.getContextPath();

        if (ok) {
            session.setAttribute("courses", cDao.getAllCourse());
            session.setAttribute("msg", "��ӳɹ���,���������һ��");

        } else {
            session.setAttribute("msg", "���ʧ�ܣ�");

        }

        session.setAttribute("path", "addCourse.jsp");
        response.sendRedirect(path + "/information.jsp");
    }

    private void delCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        CourseDao cDao = new CourseDao();
        boolean ok = cDao.delCourse(cid);
        HttpSession session = request.getSession();
        String path = request.getContextPath();
        if (ok) {
            session.setAttribute("courses", cDao.getAllCourse());
            session.setAttribute("msg", "ɾ���ɹ���");

        } else {
            session.setAttribute("msg", "ɾ��ʧ�ܣ�");

        }
        session.setAttribute("path", "Courses.jsp");
        response.sendRedirect(path + "/information.jsp");
    }

    private void modifyGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentCourse sc = new StudentCourse();
        sc.setCid(request.getParameter("cid"));
        sc.setSid(request.getParameter("sid"));
        System.out.println(sc);
        sc.setGrade(Integer.parseInt(request.getParameter("grade")));
        System.out.println(sc);

        CourseDao cDao = new CourseDao();
        boolean ok = cDao.modifyGrade(sc);

        HttpSession session = request.getSession();
        String path = request.getContextPath();
        if (ok) {
            session.setAttribute("studentCourse", cDao.getAllStudentCourse());
            session.setAttribute("msg", "�޸ĳɹ���");

        } else {
            session.setAttribute("msg", "�޸�ʧ�ܣ�");

        }
        session.setAttribute("path", "StudentCourse.jsp");
        response.sendRedirect(path + "/information.jsp");
    }
}
