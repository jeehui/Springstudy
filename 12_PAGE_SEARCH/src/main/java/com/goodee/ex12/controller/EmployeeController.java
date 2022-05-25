package com.goodee.ex12.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex12.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/employee/searchPage")
	public String searchPage() {
		return "employee/search";
	}
	
	@GetMapping("/employee/list")
	public String list(HttpServletRequest request, Model model) {
		employeeService.getEmployees(request, model);
		return "employee/search"; //search.jsp를 열면 list.jsp가 포함되어 있으므로 search.jsp로 간다.
	}
	
	@GetMapping("/employee/search")
	public String search(HttpServletRequest request, Model model) {
		employeeService.findEmployees(request, model);
		return "employee/search";
	}
	@ResponseBody //나 ajax 쓸거야? 였나..
	//속성을 두개 넣을 땐 value 명시해두기, charset은 안해도 됨
	@GetMapping(value="/employee/autoComplete", produces="application/json")
	public Map<String, Object> autoComplete(HttpServletRequest request){
		return employeeService.autoComplete(request);
		//controller은 말안해주면 반환을 다 jsp로 해주는데 이건
		//ajax로 보내고, json이 돼서 값으로 보내기때문에 명시해둬야함.
	}
	
}