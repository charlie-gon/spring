package com.company.yedam.emp.service;

import java.util.ArrayList;

import com.company.yedam.emp.dao.DeptVO;

public interface DeptService {
	
	ArrayList<DeptVO> deptList();
	void deptInsert(DeptVO vo);

}
