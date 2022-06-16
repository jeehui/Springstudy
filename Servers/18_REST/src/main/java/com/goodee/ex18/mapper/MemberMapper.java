package com.goodee.ex18.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.ex18.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public Map<String, Object> insertMember(MemberDTO member);
}
