package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DeptDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	private static DeptDAO instance;
	public static DeptDAO getInstance() {
		if(instance == null) {
			instance = new DeptDAO();
		}
		return instance;
	}
	
	
	// 전체조회
	public ArrayList<DeptVO> selectDeptList(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO vo;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setLocation_id(rs.getInt("location_id"));
				vo.setManager_id(rs.getInt("manager_id"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	
	// 부서 등록
	public void insertDept(DeptVO vo) {
		try {
			conn = JdbcUtil.connect();
			String sql = "INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getDepartment_id());
			pstmt.setString(2, vo.getDepartment_name());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건의 부서 등록 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
	}
	
	// 부서 수정
	public void updateDept(DeptVO vo) {
		
		try {
			conn = JdbcUtil.connect();
			String sql = "UPDATE DEPARTMENTS "
						+ "SET DEPARTMENT_NAME = ? "
						+ "WHERE "
						+ "DEPARTMENT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDepartment_name());
			pstmt.setInt(2, vo.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건의 부서 수정 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
	}
	
} // end of class	
