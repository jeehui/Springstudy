package com.goodee.ex05.controller;

import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	@GetMapping(value={"/", "/index"})
	public String index() { // ${contextPath}/index 요청이 오면
		return "index"; //index.jsp로 이동하다
	}
	
	@GetMapping(value="/member")//${contextPath}/board 요청이 오면,
	public String member() {
		return "member"; //member.jsp로 이동하다
	}
	
	@GetMapping(value="/board") //${contextPath}/board 요청이 오면,
	public String board() {
		return "board"; //board.jsp로 이동하자
	} //아무곳이든 이동해도 상관 없음.
	
	@GetMapping(value="/product") //${contextPath}/board 요청이 오면,
	public String product() {
		return "product"; //product.jsp로 이동하자
	}
	
	@GetMapping(value="/reservation")
	public String reservation() {
		return "reservation";
	}
	
	@GetMapping(value="/openapi")
	public String openapi() {
		return "openapi";
	}
	
	
	
}
