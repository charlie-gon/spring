package com.company.yedam.emp.dao;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobVO {
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
}
