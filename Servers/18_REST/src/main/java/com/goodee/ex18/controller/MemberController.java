package com.goodee.ex18.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex18.domain.MemberDTO;
import com.goodee.ex18.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/management")
	public String management() {
		return "member/manage";
	}
	
	@ResponseBody //json 반환하기위해 씀
	@PostMapping(value="/members", produces="application/json") //json res받기로 해서 produces 넣음 
	// json을 반환하는 세가지 방법 Map, ResponseEntity 등인데 Map을 엄청 씀.
	public Map<String, Object> addMember(@RequestBody MemberDTO member, HttpServletResponse response){
		System.out.println(member);
		return memberService.addMember(member);
	}
}
