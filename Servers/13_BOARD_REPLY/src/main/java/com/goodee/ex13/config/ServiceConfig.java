package com.goodee.ex13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.ex13.service.BoardService;
import com.goodee.ex13.service.BoardServiceImpl;
import com.goodee.ex13.service.ReplyService;
import com.goodee.ex13.service.ReplyServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
	
	@Bean
	public ReplyService replyService() {
		return new ReplyServiceImpl();
	}
}
