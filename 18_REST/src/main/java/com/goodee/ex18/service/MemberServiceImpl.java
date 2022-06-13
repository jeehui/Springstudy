package com.goodee.ex18.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.goodee.ex18.domain.MemberDTO;
import com.goodee.ex18.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Map<String, Object> addMember(MemberDTO member, HttpServletResponse response){
			Map<String, Object> map = new HashMap<>();
		try {
			map.put("res", memberMapper.insertMember(member));
		} catch(DuplicateKeyException e) { //아이디 중복으로 인한 예외
			response.setContentType("text/plain");
			response.setStatus(501);
			response.getWriter().println("이미 사용 중인 아이디입니다.");
		} catch(Exception e2) {
			e2.printStackTrace();
		} catch(DataIntegrityViolationException e) {
			try {
				System.out.println(e.getClass().getName());
				PrintWriter out = response.getWriter();
				response.setContentType("text/plain");
				response.setStatus(502);
				out.println("필수 정보가 누락되었습니다.");
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return null; //사용되지 않는 반환
	}
}
