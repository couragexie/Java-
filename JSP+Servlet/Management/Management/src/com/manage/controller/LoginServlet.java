package com.manage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage.dao.CourseDao;
import com.manage.dao.StudentDao;
import com.manage.dao.TeacherDao;
import com.manage.domain.Course;
import com.manage.domain.Student;
import com.manage.domain.StudentCourse;
import com.manage.domain.StudentInfo;
import com.manage.domain.Teacher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		String path = request.getContextPath();
		
		//System.out.println("action:" + action);
		
		if("login".equals(action)) {
			login(request, response);
		}else {

			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(path + "/login.jsp");
			
		}
			
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		
		String inumber = request.getParameter("inumber");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		System.out.println("identity:" + identity);
		
		if(identity.equals("student")) {
			// 如果登录的是学生
			StudentDao studentDao = new StudentDao();
			Student student = new Student();
			try {
				student.setsId(inumber);
			} catch (Exception ex) {
				session.setAttribute("msg", "账号密码错误，请重新登录！");
				session.setAttribute("path", "login.jsp");
				response.sendRedirect(path + "/information.jsp");
				return ;
			}
			student.setPassword(password);
			
			System.out.println(student);
			
			if (studentDao.isValid(student)) {
				// 账号密码合法
				session.setAttribute("student", student);
				session.setAttribute("sName", student.getName());
				// 学生信息
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setsId(student.getsId());
				studentDao.getStudentInfo(studentInfo);
				session.setAttribute("studentInfo", studentInfo);
				// 学生选课信息
				session.setAttribute("StudentCourses", getStudentCourse(student.getsId()));
				// 添加选课的信息
				session.setAttribute("chooseCourse", getChooseCourse(student.getsId()));
				
				response.sendRedirect(path + "/StudentIndex.jsp");
			} else {
				// 不合法
				session.setAttribute("msg", "账号密码错误，请重新登录！");
				session.setAttribute("path", "login.jsp");
				response.sendRedirect(path + "/information.jsp");
			}
			
		}else if(identity.equals("teacher")){
			StudentDao sDao = new StudentDao();
			TeacherDao tDao = new TeacherDao();
			CourseDao cDao = new CourseDao();
			Teacher teacher = new Teacher();
			teacher.setTid(request.getParameter("inumber"));
			teacher.setPassword(request.getParameter("password"));
			
			boolean ok = tDao.inVaild(teacher);
			System.out.println(teacher);
			
			if(ok) {
				//session.setAttribute("tName", teacher.getName());
				session.setAttribute("teacher", teacher);
				session.setAttribute("courses", cDao.getAllCourse());
				session.setAttribute("students", sDao.getAllStudent());
				session.setAttribute("studentCourse", cDao.getAllStudentCourse());
				response.sendRedirect("TeacherIndex.jsp");
			}else {
				session.setAttribute("msg", "登录失败！");
				session.setAttribute("path", "login.jsp");
				response.sendRedirect(path + "/information.jsp");
			}
		}	
	}
	
	
	private List<StudentCourse> getStudentCourse(String sid){
		CourseDao cDao = new CourseDao();
		return cDao.getCourseBySid(sid);
	}
	
	private List<Course> getChooseCourse(String sid){
		CourseDao cDao = new CourseDao();
		return  cDao.getChooseCourse(sid);
	}
}
