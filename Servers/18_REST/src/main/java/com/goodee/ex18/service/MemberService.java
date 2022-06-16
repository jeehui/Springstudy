package com.goodee.ex18.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.goodee.ex18.domain.MemberDTO;

public interface MemberService {
	
	
	public Map<String, Object> addMember(MemberDTO member, HttpServletResponse response);
	
}
