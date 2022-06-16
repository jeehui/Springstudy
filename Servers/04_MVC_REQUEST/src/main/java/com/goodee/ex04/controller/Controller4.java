package com.goodee.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controller4 {
	
	//redirect 하는 방법
	
	//redirect는 JSP로 이동하지 않습니다.
	//redirect는 다른 매핑으로 이동합니다.
	
	//redirect: 매핑
	
	//꼭.알.고.있.기
	
	//forward는 JSP로 이동합니다.
	//redirect는 매핑으로 이동합니다.
	
	@GetMapping("/list1")
	public String list1(HttpServletRequest request) {
		
		//forward
		//return "list"; list.jsp로 forward 이동하기
		
		//redirect는 request 전달해 주지 않아요.
		//request나 model에 저장해 봤자 최종 목적지에 전달되지 않아요.
		request.setAttribute("page", request.getParameter("page"));
		
		//redirect
		return "redirect:/list2"; // @GetMapping("/list2") 매핑으로 이동하라는 의미입니다.
		
		
	}
	
	@GetMapping("/list2")
	public String list2() {
		return "list"; //list.jsp로 forward 합니다.
	}
	
	@GetMapping("/list3")
	public String list3(int page) {
		
		return "redirect:/list4?page=" + page;
	}
	
	@GetMapping("/list4")
	public String list4(int page, Model model) {
		//String page = request.getParameter("page"); //page는 위에 list4?page= 의 파라미터 이름임.
		model.addAttribute("page", page);
		return "list";
	}
	
	//redirect 할 때 데이터 전달하는 스프링의 방법
	//1. Model 대신 RedirectAttributes 인터페이스를 사용한다.
	//2. addAttribute() 대신 addflashAttribute() 메소드를 사용한다.
	
	@GetMapping("/list5")
	public String list5(int page, RedirectAttributes redirectAttributes) { //redirect할 곳으로 데이터를 전송해 줄 수 있습니다.
		
		//addAttribute()를 쓰면 redirect 할 때 전달이 안 됩니다.
		//꼭 addFlashAttribute()를 써야 합니다.
		redirectAttributes.addFlashAttribute("page", page);
		
		return "redirect:/list6"; // page 파라미터를 안 붙여도 전달됩니다.
	}
	
	@GetMapping("/list6")
	public String list6() {
		return "list"; //list.jsp로 forward합니다.
	}
	
	//redirect는 다른 매핑으로 이동해서
	//해당 매핑의 메소드를 실행합니다.
	//그래서 redirect 대신 실행할 메소드를 호출하는 것도 가능합니다.
	
	
	}
	

