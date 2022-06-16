package com.goodee.ex06.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex06.domain.BoardDTO;
import com.goodee.ex06.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	// 컨트롤러에서
	// HttpServeletRequest, HttpServletResponse, HttpSession 을 선언할 수 있습니다.
	
	// logger
	// System.out.println() 대체
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// BoardService boardService : DI (BoardConfig.java에 저장된 bean 가져오기)
	// 1. 필드 주입    : @Autowired private BoardService boardService;
	// 2. 생성자 주입  : BoardController에 @AllArgsContructor 추가
	// 3. setter 주입  : setter 코드를 추가한 뒤 @Autowired 추가(@Setter 사용 불가)
	@Autowired
	private BoardService boardService;
		
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDTO> boards = boardService.findBoards();
		logger.info("list(): " + boards);  // 콘솔에 정보를 찍어준다.
		model.addAttribute("boards", boards);
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(value="board_no") Long board_no, Model model) {
		BoardDTO board = boardService.findBoardByNo(board_no);
		logger.info("detail(): " + board);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@GetMapping("/addPage")
	public String addPage() {
		return "board/add";  // board/add.jsp로 이동
	}
	
	@PostMapping("/add")
	public String add(BoardDTO board) {
		logger.info("add(): " + board);
		boardService.save(board);
		//삽입 후 목록보기로 redirect 하기 위해서
		//목록보기의 매핑을 확인한다.(/board/list)
		//redirect는 매핑으로 이동하기 때문에 아래와 같이 작성한다.
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	// @RequestParam(value="board_no", required=false, defaultValue="0")
	// 파라미터 board_no가 오지 않는다면 0을 사용하겠습니다.
	public String remove(@RequestParam(value="board_no", required=false, defaultValue="0") Long board_no) {
		logger.info("remove(): " + board_no);
		boardService.remove(board_no);
		return "redirect:/board/list";
		//삭제 후에는 목록보기로 redirect한다.
	}
	
//	@PostMapping("/board/modifyPage")
//	public String modifyPage(BoardDTO board, Model model) {
//		logger.info("modifyPage(): " + board);
//		model.addAttribute("board", board);
//		return "board/modify";  // board/modify.jsp로 forward
//	}
	
	@PostMapping("/modifyPage")
	public String modifyPage(@ModelAttribute(value="board") BoardDTO board) {
		logger.info("modifyPage(): " + board);
		return "board/modify";  // board/modify.jsp로 forward
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO board) {
		logger.info("modify(): " + board);
		boardService.modify(board);
		return "redirect:/board/detail?board_no=" + board.getBoard_no();
		// save(), remove() 메소드처럼 modify() 메소드에서 직접 이동한다.
	}
	
}