package com.goodee.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex04.domain.Member;

@Controller
public class Controller1 {
	
	@GetMapping("/") // http://localhost:9090/ex04 이 주소로 연결되면,
	public String index() {
		return "index";	// index.jsp로 갑니다 
			
	}
	
	@GetMapping("/detail1") // <a href="${contextPath}/detail1?name=민경태&age=45"
	public String detail(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(name, age);
		request.setAttribute("member", member);
		
		return "detail"; //detail.jsp로 forward 합니다.
		
	}
	
	@GetMapping("/detail2")
	public String detail2(HttpServletRequest request, Model model) {
		//요청은 request가 처리한다.
		//forward 할 데이터를 model이 처리한다.
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(name, age);
		
		//스프링에서 사용하는 데이터 전달용 Model
		//내부적으로는 request를 사용해서 전달한다.
		//model을 사용함으로써 보안이 향상된다.
		//대부분 Model을 쓴다.
		model.addAttribute("member", member); // 사실 request.setAttribute("member", member)와 같다.
		
		
		return "detail"; //detail.jsp로 forward합니다.
	}
	
	@GetMapping("/detail3")
	public String detail3(@RequestParam(value="name", required=false, defaultValue = "아무개")String name,  //파라미터 name을 String name에 저장해 줌
						  @RequestParam(value="age", required=false, defaultValue = "0")int age,
							Model model) {   //파라미터 age를 int age에 저장해 줌
		/*
		@RequestParam 사용법
		value= "파라미터"     : 전달되는 파라미터 이름이다.
		required=false 		  : 꼭 필요한 파라미터가 아니다. 없어도 된다. 정확하게 에러안뜨게 하겠다.
								(기본값은 required=true 이다.)
		defaultValue="기본값" : 파라미터가 없으면 사용할 값이다.
		
		@RequestParam 애너테이션을 지워도 잘 동작합니다.
		이 애너테이션은 String name, int age와 같이 변수 앞에서만 작동함.
		
		*/
		
		model.addAttribute("member", new Member(name, age));
		
		return "detail";
	}
	
	@GetMapping("/detail4")
	public String detail4(Member member, // 파라미터 name과 age를 Member 클래스의 setter(setName, setAge)가 파라미터를 받아 준다.
						  Model model) {
		model.addAttribute("member", member);
		return "detail";
	}
	
	@GetMapping("/detail5")
	public String detail5(@ModelAttribute Member member) {
		//@ModelAttribute(value="member") Member member
		
		//파라미터 name과 age를 Member member에 저장하고,
		//Model에 member 속성(attribute)로 저장해 주세요.
		return "detail";
	}
	
}
