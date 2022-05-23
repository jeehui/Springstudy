package com.goodee.ex10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodee.ex10.domain.NoticeDTO;
import com.goodee.ex10.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index");
		return "index";
	}
	
	@GetMapping("/notice/list")
	public String list(Model model) {
		model.addAttribute("notices", noticeService.findNotices());
		return "notice/list"; //notice 폴더 아래 list.jsp로 이동
	}
	
	@GetMapping("/notice/savePage")
	public String savePage() {
		return "notice/save"; //notice 폴더 아래 save.jsp로 이동
	}
	
	@PostMapping("/notice/save")
	// public String save(@RequestParam String title, @RequestParam String content)
	// public String save(NoticeDTO notice)
	public String save(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		NoticeDTO notice = new NoticeDTO();
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		int res = noticeService.save(notice);

		// 성공/실패 메시지 처리가 없는 경우
		// return "redirect:/notcie/list"; //redirect는 매핑으로 이동한다. 목록보기매핑(/notice/list)
		
		// 성공/실패 메시지 처리를 담당하는 result.jsp를 만들고, 
		// result.jsp로 redirect로 이동하는 방법을 사용한다.
		// result.jsp로 성공/실패 유무, 작업종류를 보내줘야 하는데, 
		// redirect로 이동하는 경우에는 RedirectAttributes에 정의된 addFlashAttribute() 메소드를
		// 이용해서 값을 전달할 수 있다.
		redirectAttributes.addFlashAttribute("kind", "insert");
		redirectAttributes.addFlashAttribute("res", res);
		
		return "redirect:/notice/afterDML";
	}
	
	@GetMapping("/notice/afterDML")
	public String afterDML() {
		return "notice/result"; // notice 폴더 아래 result.jsp를 의미한다.
	}
	
	@GetMapping("/notice/detail")
	public String detail(@RequestParam Long noticeNo, Model model) {
		//					notice라는 이름을 detail에게 전달 그 속에는 noticeService.findNoticeByNo(noticeNo)가 들어있음
		model.addAttribute("notice", noticeService.findNoticeByNo(noticeNo));
		return "notice/detail"; //notice 폴더 아래 detail.jsp를 의미한다.
	}
	
	
	
	
	
	
	
}