package com.manage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manage.domain.Teacher;
import com.manage.util.DBUtil;

public class TeacherDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null;
	
	public boolean inVaild(Teacher teacher) {
		
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM teacher WHERE tid=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTid());
			pstmt.setString(2, teacher.getPassword());
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				teacher.setName(rs.getString(2));
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}
	
	
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
}
