package com.goodee.ex13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

@Configuration
public interface ReplyService {
		//반환타입을 Map으로
		public Map<String, Object> findReplies(Long BoardNo);
		public Map<String, Object> saveReply(HttpServletRequest request);
		public Map<String, Object> removeReply(Long replyNo);
}
