package com.goodee.ex14.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public interface FreeBoardService {
	//ip꺼내려면 request가 편함
	public void findFreeBoards(HttpServletRequest request, Model model);
	public int saveFreeBoard(HttpServletRequest request);
	public int saveReply(HttpServletRequest request);
	public int removeFreeBoard(Long freeBoardNo);
}	
