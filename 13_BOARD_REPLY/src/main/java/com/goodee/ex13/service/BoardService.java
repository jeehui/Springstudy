package com.goodee.ex13.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

import com.goodee.ex13.domain.BoardDTO;

@Configuration
public interface BoardService {
	public void findBoards(HttpServletRequest request, Model model);
	public void findBoardByNo(HttpServletRequest request,HttpServletResponse response, Model model);
	//title, content, ip 등을 받을 수 있는게 request가 편함. 
	//작성 ip 때문에 더더욱 request
	public int save(HttpServletRequest request);
	//BoardDTO를 받는게 더 빨리 update가 됨
	public int change(BoardDTO board);
	//boardNo를 받고 삭제하기에! boardNo받음
	public int remove(Long boardNo);
}
