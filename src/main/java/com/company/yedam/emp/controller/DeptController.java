package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.DeptVO;

@Controller
public class DeptController {
	
	@Autowired DeptDAO deptDAO;
	
	// 부서 조회(등록폼)
	@GetMapping("/deptInsert")
	public String deptInsert(HttpServletRequest request) {
		request.setAttribute("list", deptDAO.selectDeptList());
		return "dept/deptInsert";
	}
	
	// 부서 등록
	@PostMapping("/deptInsert")
	public String deptInsertProc(DeptVO vo) {
		deptDAO.insertDept(vo);
		return "redirect:deptInsert";
	}

}
