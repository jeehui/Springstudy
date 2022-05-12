package com.goodee.ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.ex03.domain.Member;

@Configuration
public class MemberConfig {
	
	//자바로 bean을 만드는 경우에는
	//bean의 이름(id)이 qualifier역할을 수행합니다.
	//자바로 만들때는 id를 보고 구현함.
	
	@Bean
	public Member member1() {
		
		Member member = new Member();
		member.setId("admin");
		member.setPw("123456");
		
		return member;
	}
	
	
}
