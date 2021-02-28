package com.company.yedam.emp.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.dao.JobDAO;

@Controller // == @Component와 동일한 의미(컨테이너 bean으로 등록 / 컨트롤러 기능)
public class EmpController {
	
	// Autowired는 상단에 모다 놓는다
	@Autowired EmpDAO empDAO;
	@Autowired JobDAO jobDAO;
	@Autowired DeptDAO deptDAO;

	// 사원목록
	@RequestMapping("/empList")
	public String empList(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empList"; // src/main/webapp/WEB-INF/views/emp/
	}
	
	// 등록폼
	@GetMapping("/empInsert")
	public String empInsert(HttpServletRequest request) {
		request.setAttribute("jobList", jobDAO.selectJobList());
		request.setAttribute("deptList", deptDAO.selectDeptList());
		return "emp/empInsert";
	}
	
	// 등록처리
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		empDAO.insert(vo);
		return "redirect:empInsert";
	}
	
	// 수정폼
	// 확인: http://localhost/yedam/empUpdate?employee_id=사원번호 
	@GetMapping("/empUpdate")
	public String empUpdate(HttpServletRequest request) {
		String empId = request.getParameter("employee_id");
		request.setAttribute("empVo", empDAO.selectOne(empId));
		request.setAttribute("jobList", jobDAO.selectJobList());
		request.setAttribute("deptList", deptDAO.selectDeptList());
		
		return "emp/empInsert";
	}
	
	// 수정처리
	@PostMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		empDAO.update(vo);
		return "redirect:empList";
	}
	
	// 이메일체크
	@RequestMapping("/emailCheck")
	public String emailCheck(String email) {
		empDAO.selectOneByEmail(email);
		return "emp/empInsert";
	}
	
	// 사원검색
	@RequestMapping("/empSearch")
	public String empSearch(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empSearch";
	}
}
