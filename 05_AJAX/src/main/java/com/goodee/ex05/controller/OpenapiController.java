package com.goodee.ex05.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.ex05.domain.OpenapiDTO;
import com.goodee.ex05.service.OpenapiService;

@Controller
public class OpenapiController {
	
	@Autowired
	private OpenapiService openapiService;
	
	@ResponseBody
	@GetMapping(value="/dailyBoxOffice", produces="application/json; charset=UTF-8")
	public Map<String, Object> dailyBoxOffice(OpenapiDTO openapi){
		Map<String, Object> res = openapiService.dailyBoxOffice("openapi");
		return res;
	}
	
}
