package com.manage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.manage.domain.Course;
import com.manage.domain.StudentCourse;
import com.manage.util.DBUtil;

public class CourseDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;
//	
//	try {
//		
//	}catch(Exception e) {
//		
//	}finally {
//		close();
//	}
	private void close() {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
				//conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			String sql = "Select * from course";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		
			
			while(rs.next()) {
				Course course  = new Course();
				course.setCid(rs.getString(1));
				course.setCname(rs.getString(2));
				course.setCredit(rs.getInt(3));
				courses.add(course);
			}
		}catch(Exception e) {
				
		}finally {
			close();
		}
		
		return courses;
	}
	
	// 获取学生选课的信息，分别从两张表中获取
	public List<StudentCourse> getCourseBySid(String sid){
		List<StudentCourse> scs = new ArrayList<>();
		try {
			// 从 s-c 选课表中获取数据
			conn = DBUtil.getConnection();
			String sql1 = "select * from s_c where sid=?"; 
			pst = conn.prepareStatement(sql1);
			pst.setString(1, sid);
			rs = pst.executeQuery();
			while(rs.next()) {
				StudentCourse sc = new StudentCourse();
				sc.setCid(rs.getString(2));
				sc.setSid(rs.getString(3));
				sc.setGrade(rs.getInt(4));
				scs.add(sc);
			}
			// 从 course 表中获取数据
			for(StudentCourse sc1: scs) {
				String sql2 = "select * from course where cid=?";
				pst = conn.prepareStatement(sql2);
				pst.setString(1, sc1.getCid());
				rs = pst.executeQuery();
				if(rs!=null&&rs.next()) {
					sc1.setCname(rs.getString(2));
					sc1.setCredit(rs.getInt(3));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		return scs;
	}
	
	public List<Course> getChooseCourse(String sid){
		List<StudentCourse> scs = getCourseBySid(sid);
		List<Course> cs = getAllCourse();
		List<Course> choose = new ArrayList<>();
		int flag = 1;
		for(Course c : cs) {
			flag = 1;
			for(StudentCourse sc : scs) {
				if(sc.getCid().equals(c.getCid())) {
					flag = 0;
					System.out.println(c.getCname() + " exit!");
					break;
				}
			}
			if(flag == 1)
				choose.add(c);
		}
		for(Course c: choose)
			System.out.println(c);
		
		return choose;
	}
	
	public boolean chooseCourese(StudentCourse sc) {
		int ok = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO s_c (cid,sid,grade) VALUES(?, ?, ?) ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, sc.getCid());
			pst.setString(2, sc.getSid());
			pst.setInt(3, 0);
			ok = pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return false; 
		}finally {
			close();
		}	
		if(ok == 1)
			return true;
		else
			return false;
	}
	public boolean delChooseCourese(StudentCourse sc) {
		int ok = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "DELETE FROM s_c WHERE cid=? AND sid=?" ;
			pst = conn.prepareStatement(sql);
			pst.setString(1, sc.getCid());
			pst.setString(2, sc.getSid());
			ok = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			close();
		}	
		if(ok == 1)
			return true;
		else
			return false;
	}
	
	public boolean addCourse(Course course) {
		int ok = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into course(cid, cname,credit) values(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, course.getCid());
			pst.setString(2, course.getCname());
			pst.setInt(3, course.getCredit());
			
			ok = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		if(ok == 1)
			return true;
		else
			return false;
	}
	
	public boolean delCourse(String cid) {
		int ok = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from course where cid=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, cid);
					
			ok = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		if(ok == 1)
			return true;
		else
			return false;
	}
	
	public boolean modifyGrade(StudentCourse sc) {
		int ok = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "update s_c set grade=? where sid=? and cid=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sc.getGrade());
			pst.setString(2, sc.getSid());
			pst.setString(3, sc.getCid());
			
			ok = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		if(ok == 1)
			return true;
		else
			return false;
	}
	
	public List<StudentCourse> getAllStudentCourse() {
		//List<Course> courses = getAllCourse();
		List<StudentCourse> scs = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from s_c";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				StudentCourse sc = new StudentCourse();
				sc.setCid(rs.getString(2));
				sc.setSid(rs.getString(3));
				sc.setGrade(rs.getInt(4));
				scs.add(sc);
			}		
			close();
			conn = DBUtil.getConnection();
			for(StudentCourse sc1: scs) {
				String sql2 = "select * from course where cid=?";
				pst = conn.prepareStatement(sql2);
				pst.setString(1, sc1.getCid());
				rs = pst.executeQuery();
				if(rs!=null && rs.next()) {
					sc1.setCname(rs.getString(2));
					sc1.setCredit(rs.getInt(3));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		for(StudentCourse sc : scs)
			System.out.println(sc);
		
		return scs;
	}
	
	
	public static void main(String args[]) {
		CourseDao cDao = new CourseDao();
		List<StudentCourse> scs = cDao.getAllStudentCourse();
		for(StudentCourse sc : scs)
			System.out.println(sc);
	}
	
}
