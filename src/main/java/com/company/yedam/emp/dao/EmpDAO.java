package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;


/*
 * VO = Value Object = DTO(Data Transfer Object)
 * DAO = Data Access Object
 */
@Component
public class EmpDAO {

	Connection conn;
	PreparedStatement pstmt;
	
	// 전체 조회
	public ArrayList<EmpVO> selectList(){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo;
		try {
			// connect
			conn = JdbcUtil.connect();
			// statement
			String sql = "SELECT "
					+ "EMPLOYEE_ID,"
					+ "FIRST_NAME,"
					+ "LAST_NAME,"
					+ "EMAIL,"
					+ "PHONE_NUMBER,"
					//+ "to_char(HIRE_DATE, 'yyyy-MM') hire_date,"
					+ "HIRE_DATE,"
					+ "JOB_ID,"
					+ "SALARY,"
					+ "COMMISSION_PCT,"
					+ "MANAGER_ID,"
					+ "DEPARTMENT_ID "
					+ "FROM EMPLOYEES ORDER BY EMPLOYEE_ID";
			pstmt = conn.prepareStatement(sql);
			// execute
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString(1));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setSalary(rs.getString("salary"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setEmail(rs.getString("email"));
				vo.setDepartment_id(rs.getString("department_id"));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace(); // 세부 에러 메시지 출력
			System.out.println(e.getMessage()); // 에러 메시지만 출력
		}finally {
			JdbcUtil.disconnect(conn);
		}
		
		return list;
	}
	
	// 단 건 조회
	public EmpVO selectOne(String id) {
		EmpVO vo = null;
		try {
			// connect
			conn = JdbcUtil.connect();
			// statement
			String sql = "SELECT "
					+ "EMPLOYEE_ID,"
					+ "FIRST_NAME,"
					+ "LAST_NAME,"
					+ "EMAIL,"
					+ "PHONE_NUMBER,"
					+ "HIRE_DATE,"
					+ "JOB_ID,"
					+ "SALARY,"
					+ "COMMISSION_PCT,"
					+ "MANAGER_ID,"
					+ "DEPARTMENT_ID "
					+ "FROM EMPLOYEES "
					+ "WHERE EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			// execute
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString(1));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setDepartment_id(rs.getString("department_id"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setDepartment_id(rs.getString("department_id"));
			}
		}catch(Exception e) {
			e.printStackTrace(); // 세부 에러 메시지 출력
			System.out.println(e.getMessage()); // 에러 메시지만 출력
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	// 이메일 조회
		public EmpVO selectOneByEmail(String email) {
			EmpVO vo = null;
			try {
				// connect
				conn = JdbcUtil.connect();
				// statement
				String sql = "SELECT * FROM EMPLOYEES WHERE EMAIL = ?";
				pstmt = conn.prepareStatement(sql);
				// execute
				pstmt.setString(1, email);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new EmpVO();
					vo.setEmployee_id(rs.getString("employee_id"));
					vo.setFirst_name(rs.getString("first_name"));
					vo.setLast_name(rs.getString("last_name"));
					vo.setEmail(rs.getString("email"));
					vo.setPhone_number(rs.getString("phone_number"));
					vo.setHire_date(rs.getDate("hire_date"));
					vo.setJob_id(rs.getString("job_id"));
					vo.setSalary(rs.getString("salary"));
					vo.setCommission_pct(rs.getString("commission_pct"));
					vo.setManager_id(rs.getString("manager_id"));
					vo.setDepartment_id(rs.getString("department_id"));
					
				}
			}catch(Exception e) {
				e.printStackTrace(); // 세부 에러 메시지 출력
				System.out.println(e.getMessage()); // 에러 메시지만 출력
			}finally {
				JdbcUtil.disconnect(conn);
			}
			return vo;
		}
	
		
	// 단 건 삽입
	public void insert(EmpVO vo) {
		
		try {
		// 1. connect(연결)
			conn = JdbcUtil.connect();
		// 2. statement(구문)
			String sql = "INSERT INTO EMPLOYEES "
							+ "(EMPLOYEE_ID,"
							+ "FIRST_NAME,"
							+ "LAST_NAME,"
							+ "EMAIL,"
							+ "HIRE_DATE,"
							+ "JOB_ID) "
							+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		// 3. execute(실행)
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getLast_name());
			pstmt.setString(4, vo.getEmail());
			pstmt.setDate(5, vo.getHire_date());
			pstmt.setString(6, vo.getJob_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 등록됨");
		// 4. resultset(select라면 조회결과처리)
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		// 5. close(연결해제)
			JdbcUtil.disconnect(conn);
		}
	}
	
public void update(EmpVO vo) {
		
		try {
		// 1. connect(연결)
			conn = JdbcUtil.connect();
		// 2. statement(구문)
			String sql = "UPDATE EMPLOYEES SET EMAIL = ? WHERE EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getEmployee_id());
			pstmt.executeUpdate();
		
		// 3. execute(실행)
		
		// 4. resultset(select라면 조회결과처리)
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		// 5. close(연결해제)
			JdbcUtil.disconnect(conn);
		}
	}
} // end of class
