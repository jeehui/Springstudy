package com.goodee.ex11;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.ex11.service.NoticeService;

public class NoticeTestCase {

	@Autowired
	private NoticeService noticeService;
	
	@Test 
	public void test(HttpServletRequest request) {
		int res = noticeService.save(request);
		
	}

}
