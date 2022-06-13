package com.goodee.ex18.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.ex18.service.GalleryService;
import com.goodee.ex18.service.GalleryServiceImpl;
import com.goodee.ex18.service.MemberService;
import com.goodee.ex18.service.MemberServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
	
	@Bean
	public GalleryService galleryService() {
		return new GalleryServiceImpl();
	}
	
}
