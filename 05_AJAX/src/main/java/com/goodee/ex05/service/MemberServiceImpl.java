package com.goodee.ex05.service;

import javax.servlet.http.HttpServletRequest;

import com.goodee.ex05.domain.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Override
	public String detail1(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		return "입력 아이디: " + id + "입력 비밀번호: " + pw; //컨트롤러에 반환할 텍스트
	}
	@Override
	public MemberDTO detail2(String id, String pw) { //컨트롤러에서 받아온 id와 pw
		
		MemberDTO member = new MemberDTO(); //디폴트로 만들었다면 setter가 필요함
		member.setId(id);
		member.setPw(pw);
		
		return member;						//컨트롤러로 반환하는 객체
	}
}
