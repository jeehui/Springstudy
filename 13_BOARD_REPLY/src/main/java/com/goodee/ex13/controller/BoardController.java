package com.goodee.ex13.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.ex13.domain.BoardDTO;
import com.goodee.ex13.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String list(HttpServletRequest request, Model model) {
		boardService.findBoards(request, model);
		return "board/list";
	}
	
	@GetMapping("/board/savePage")
	public String savePage() {
		return "board/save";
	}
	
	@PostMapping("/board/save")
	//void 로 하면 반환하지 않겠다. response로 쓰면되는데 에러메시지를 표시하고 싶을때 저 코드를 쓴다.
	//public void save(HttpServletResponse response)
	
	//메시지 없이 이동만 하겠다.
	//public String save()
	 //return "redirect:/board/list"
	
	//메시지 뜨게 만든다. redirect할때는 정보전달 못하기때문에 Model쓰지 못함.
	public String save(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		//addFlashAttribute = model.addAttribute와 같이 꼭 넣어야한다!
		redirectAttributes.addFlashAttribute("insRes", boardService.save(request));
		redirectAttributes.addFlashAttribute("type","insert");
		return "redirect:/board/result"; // 매핑/board/result로 redirect 하겠다.
	}
	
	@GetMapping("/board/result")
	public String result() {
		return "board/result"; //board/result.jsp로 이동하겠다.
	}
	
	@GetMapping("/board/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		//service에 있는 데이터를 request, model로 받아서
		boardService.findBoardByNo(request,response, model);
		//서비스를 실행해서 board/detail.jsp로 반환한다.
		return "board/detail";
	}
	
	@GetMapping("/board/changePage")
	public String changePage() {
		return "board/change";	
	}
	
	@PostMapping("/board/change")
	public String change(BoardDTO board, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("updRes",boardService.change(board));
		redirectAttributes.addFlashAttribute("type","update");
		return "redirect:/board/result";
	}
	
	@GetMapping("/board/remove")
	public String remove(@RequestParam(value="boardNo", required=false, defaultValue ="0") Long boardNo
						,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("delRes", boardService.remove(boardNo));
		redirectAttributes.addFlashAttribute("type","delete");
		return "redirect:/board/result";
		
	}
}
