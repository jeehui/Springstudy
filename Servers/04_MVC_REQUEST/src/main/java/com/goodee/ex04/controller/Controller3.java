package com.goodee.ex04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex04.domain.Product;

@Controller
public class Controller3 {
	
	@PostMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/remove1")
	public String remove1(HttpServletRequest request, Model model) {
		
		String models = request.getParameter("models");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product product = new Product(models, price);
		
		model.addAttribute("product", product);
		
		return "product";
	}
	
	@PostMapping("/remove2")
	public String remove2(@RequestParam(value="models")String models,
						  @RequestParam(value="price")int price, Model model) {
		model.addAttribute("product", new Product(models, price));
		
		return "product";
	}
	
	@PostMapping("/remove3")
	public String remove3(Product product, Model model) {
		model.addAttribute("product", product);
		return "product";
	}
	
}
