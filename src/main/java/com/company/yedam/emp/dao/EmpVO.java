package com.company.yedam.emp.dao;


import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date hire_date;
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	
	
}
