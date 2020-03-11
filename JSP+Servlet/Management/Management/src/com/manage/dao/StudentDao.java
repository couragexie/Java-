package com.manage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.manage.domain.Student;
import com.manage.domain.StudentInfo;
import com.manage.util.DBUtil;

public class StudentDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null;
	
//	public StudentDao(){
//		try {
//			conn = DBUtil.getConnection();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	
//	try {
//		
//	}catch(Exception e) {
//		
//	}finally {
//		close();
//	}
//	
//	
//	}
	private void close() {
		if (pstmt != null) {
			try {
				pstmt.close();
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
	
	public boolean isValid(Student student) {
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from student where sid=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getsId());
			pstmt.setString(2, student.getPassword());
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				student.setName(rs.getString("name"));
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
		
		return false;
	}

	public void getStudentInfo(StudentInfo studentInfo) {
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from student_info where sid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentInfo.getsId());
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				studentInfo.setName(rs.getString(2));
				studentInfo.setMajor(rs.getString(3));
				studentInfo.setAge(rs.getInt(4));
				studentInfo.setSex(rs.getString(5));
				studentInfo.setClass_(rs.getInt(6));
				studentInfo.setPosition(rs.getString(7));
				studentInfo.setDormitory(rs.getString(8));
				studentInfo.setPhoneNum(rs.getString(9));
				studentInfo.setEmail(rs.getString(10));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public boolean modifyPw(Student student) {
		System.out.println(student);
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();// 执行语句

			String sql = "update student set password="+student.getPassword() + " where sid="+student.getsId();
			int ok = stmt.executeUpdate(sql);
			if(ok!=0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return false;
	}

	public static void main(String[] args) {
		
		StudentDao studenDao = new StudentDao();
		StudentInfo s = new StudentInfo();
		s.setsId("3117004111");
		s.setName("黄晓明");
		s.setAge(22);
		s.setClass_(170807);
		s.setDormitory("622");
		s.setPosition("学习委员");
		s.setPhoneNum("123456");
		s.setEmail("111@163.com");
		s.setMajor("信息安全");
		s.setSex("男");
		System.out.println(studenDao.modifyInfo(s));	
		
	}
	
	public List<StudentInfo> getAllStudent(){
		List<StudentInfo> s = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			
			String sql = "SELECT * FROM student_info ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setsId(rs.getString(1));
				studentInfo.setName(rs.getString(2));
				studentInfo.setMajor(rs.getString(3));
				studentInfo.setAge(rs.getInt(4));
				studentInfo.setSex(rs.getString(5));
				studentInfo.setClass_(rs.getInt(6));
				studentInfo.setPosition(rs.getString(7));
				studentInfo.setDormitory(rs.getString(8));
				studentInfo.setPhoneNum(rs.getString(9));
				studentInfo.setEmail(rs.getString(10));
		
				s.add(studentInfo);			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return s;
	}
	
	public boolean modifyInfo(StudentInfo studentInfo) {
		int ok = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE student_info SET "
					+ "name=?, major=?, age=?, sex=?, class_=?, position=?, dormitory=?, phoneNum=?, email=?"
					+ "where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentInfo.getName());
			pstmt.setString(2, studentInfo.getMajor());
			pstmt.setInt(3, studentInfo.getAge());
			pstmt.setString(4, studentInfo.getSex());
			pstmt.setInt(5, studentInfo.getClass_());
			pstmt.setString(6, studentInfo.getPosition());
			pstmt.setString(7, studentInfo.getDormitory());
			pstmt.setString(8, studentInfo.getPhoneNum());
			pstmt.setString(9, studentInfo.getEmail());
			pstmt.setString(10, studentInfo.getsId());
			
			ok = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			ok = -1;
		}finally {
			close();
		}
		if(ok == 1)
			return true;
		else
			return false;
		
	}
	
	
}
