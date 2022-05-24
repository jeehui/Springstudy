package com.goodee.ex11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.ex11.service.NoticeService;
import com.goodee.ex11.service.NoticeServiceImpl;

@Configuration
public class NoticeConfig {
		
	@Bean	//bean은 클래스가 있어야 만들 수 있다.
	public NoticeService noticeService() {
		return new NoticeServiceImpl();
	}
	

	
}