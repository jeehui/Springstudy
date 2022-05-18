package com.goodee.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.test.domain.BoardDTO;

public interface BoardService {
	public List<BoardDTO> findBoards();
	public BoardDTO findBoardByNo(Long board_no);
	public void save(BoardDTO board, HttpServletRequest request, HttpServletResponse response);
	public void modify(BoardDTO board, HttpServletRequest request, HttpServletResponse response);
}
