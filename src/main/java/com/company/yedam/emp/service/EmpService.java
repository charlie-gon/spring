package com.company.yedam.emp.service;

import java.util.ArrayList;

import com.company.yedam.emp.dao.EmpVO;

public interface EmpService {
	
	//메서드 하나 하나가 joinpoint
	void empInsert(EmpVO vo);
	void empUpdate(EmpVO vo);
	void empDelete(EmpVO vo);
	EmpVO empSearch(EmpVO vo);
	ArrayList<EmpVO> empList();
	EmpVO selectOne(EmpVO vo);
	
}
