package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class JobDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	private static JobDAO instance;
	public static JobDAO getInstance() {
		if(instance == null) {
			instance = new JobDAO();
		}
		return instance;
	}
	
	public ArrayList<JobVO> selectJobList(){
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		JobVO vo;
		try {
			conn = JdbcUtil.connect();
			String sql = "select * from jobs order by job_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new JobVO();
				vo.setJob_id(rs.getString("job_id"));
				vo.setJob_title(rs.getString("job_title"));
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
