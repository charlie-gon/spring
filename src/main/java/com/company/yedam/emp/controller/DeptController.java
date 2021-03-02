package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.service.DeptService;

@Controller
public class DeptController {
	
//	@Autowired DeptDAO deptDAO;
	@Autowired DeptService deptService;
	
	// 부서 조회
	@RequestMapping("deptList")
	public String deptList(Model model) {
		model.addAttribute("list", deptService.deptList());
		return "dept/deptList";
	}
	
	// 부서 조회(등록폼)
	@GetMapping("/deptInsert")
	public String deptInsert(Model model) {
		model.addAttribute("list", deptService.deptList());
		return "dept/deptInsert";
	}
	
	// 부서 등록
	@PostMapping("/deptInsert")
	public String deptInsertProc(DeptVO vo) {
		deptService.deptInsert(vo);
		return "redirect:deptInsert";
	}

}
