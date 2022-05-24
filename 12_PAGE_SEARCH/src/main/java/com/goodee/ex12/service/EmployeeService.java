package com.goodee.ex12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmployeeService {

	public void findEmployees(HttpServletRequest request, Model model);
	
	
}
