package com.goodee.ex12.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmployeeService {

	public void findEmployees(HttpServletRequest request, Model model);
	public void getEmployees(HttpServletRequest request, Model model);
	public Map<String, Object> autoComplete(HttpServletRequest request);
	
	
}
