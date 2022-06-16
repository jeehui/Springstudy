package com.goodee.history.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.history.service.HistoryService;
import com.goodee.history.service.HistoryServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public HistoryService historyService() {
		return new HistoryServiceImpl();
	}
	
}
