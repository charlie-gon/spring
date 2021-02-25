package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
		
	}
	
}	
