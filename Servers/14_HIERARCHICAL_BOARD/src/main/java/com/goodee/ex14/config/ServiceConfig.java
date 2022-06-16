package com.goodee.ex14.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.ex14.service.FreeBoardService;
import com.goodee.ex14.service.FreeBoardServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public FreeBoardService freeBoardService() {
		return new FreeBoardServiceImpl();
	}
}
