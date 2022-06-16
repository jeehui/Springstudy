package com.goodee.test.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.test.domain.BoardDTO;
import com.goodee.test.repository.BoardRepository;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<BoardDTO> findBoards() {
		return boardRepository.selectBoards();
	}

	@Override
	public BoardDTO findBoardByNo(Long no) {
		return boardRepository.selectBoardByNo(no);
	}

	@Override
	public void save(BoardDTO board, HttpServletRequest request, HttpServletResponse response) {
		int res = boardRepository.insertBoard(board);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(res > 0) {
				out.println("<script>");
				out.println("alert('등록되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/board/list");  // location 이동은 redirect와 같은 방식의 이동이다.
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('등록되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(BoardDTO board, HttpServletRequest request, HttpServletResponse response) {
		int res = boardRepository.updateBoard(board);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(res > 0) {
				out.println("<script>");
				out.println("alert('수정되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/board/list");  // location 이동은 redirect와 같은 방식의 이동이다.
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('수정되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
