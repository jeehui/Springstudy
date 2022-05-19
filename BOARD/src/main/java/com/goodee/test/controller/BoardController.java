package com.goodee.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goodee.test.domain.BoardDTO;
import com.goodee.test.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board/list")
	public String list(Model model) {
		List<BoardDTO> boards = boardService.findBoards();
		logger.info("list(): " + boards);
		model.addAttribute("boards", boards);
		return "board/list";
	}
	
	//list.jsp 새글작성 a링크 주소를 위해 만든거임
	//add는 post라서 get이 불가하기에 addPage를 따로만들어서 board/add.jsp로 보내려고 하는걸지도..?
	@GetMapping("/board/addPage")
	public String addPage() {
		return "board/add";
	}
	
	@PostMapping("/board/add")
	//void 메소드는 return 반환하지 않음.
	public void add(BoardDTO board, HttpServletRequest request, HttpServletResponse response) {
		logger.info("add(): " + board);
		boardService.save(board, request, response);
		//boardService의 save()메소드에서 직접 이동했다는 걸 의미
	}
}
