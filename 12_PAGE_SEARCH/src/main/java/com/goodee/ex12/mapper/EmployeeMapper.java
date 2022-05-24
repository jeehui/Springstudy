package com.goodee.ex12.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex12.domain.Employee;

@Mapper
public interface EmployeeMapper {
	
	public List<Employee> selectEmployees(Map<String, Object> map);
	public int selectEmployeeCount();
	
}
