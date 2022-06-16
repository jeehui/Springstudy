package com.goodee.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.test.repository.BoardRepository;
import com.goodee.test.service.BoardService;
import com.goodee.test.service.BoardServiceImpl;

@Configuration
public class BoardConfig {
	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
	@Bean
	public BoardRepository boardRepository() {
		return new BoardRepository();
	}
	
}
