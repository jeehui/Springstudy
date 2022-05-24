package com.goodee.ex12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.ex12.service.EmployeeService;
import com.goodee.ex12.service.EmployeeServiceImpl;

@Configuration
public class EmployeeServiceConfig {
	
	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}
}
