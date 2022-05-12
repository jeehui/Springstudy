package com.goodee.ex03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodee.ex03.domain.Board;

@Controller
public class BoardController {
	
	//Spring4부터 새로운 애너테이션이 지원
	
	//@GetMapping("/") == @RequestMapping(value="/", method=RequestMethod.GET)
	//@PostMapping("/")== @RequestMapping(value="/", method=RequestMethod.POST)
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index"; // 뷰 리졸버에 의해서 "/WEB-INF/views/index.jsp"로 변환됩니다.

		
	}
	
	//field
	//1. 필드에 @Autowired 사용하기
	//	 필드마다 @Autowired를 추가해야 한다.(필드가 10개면 @Autowired도 10개)
	//	 필드가 많은 경우 사용하지 않는 것이 좋다.
	//@Autowired
	//private Board board1;
	
	//2. 생성자 주입
	//private Board board1;
	//Board board1 에서 읽히는건 Board만 읽힘 board1과 같은 id는 변경돼도 상관 없음
	//com.goodee.ex03.domain.Board가 Board를 읽고 구현함.
	//public BoardController(Board board2) { //매개변수 Board board2으로 주입됩니다. 이런걸 DI라고함 dependency injection
	//	super();
	//	this.board1 = board2;
	//}
	
	//3. setter 주입
	//	 setter의 매개변수로 주입된다.
	//	 @Autowired를 setter에 작성해 준다.
	//	 @Autowired가 추가된 메소드의 매개변수는 모두 주입된다.(꼭 setter가 아니어도 된다.)
	
	//private Board board1;
	
	//@Autowired
	//public void setBoard1(Board board1) {
	//	this.board1 = board1;
	//}
	
	
	//동일한 타입(class)의 bean이 여러 개인 경우
	//@Autowired만으로는 bean의 주입이 되지 않기 때문에, 
	//@Qualifier 애너테이션으로 bean의 구분을 한다.
	
	@Autowired
	@Qualifier(value="board1") //<qualifier value="board1"/> 이 bean을 주입해 주세요.
	private Board board1;
	
	@Autowired
	@Qualifier(value="board2") // <qualifier value="board2"/> 이 bean을 주입해 주세요.
	private Board board2;
	

	//@GetMapping("board/detail") 이걸 사용할 거지만, 
	//@GetMapping("board/detail") 매핑이 슬래시(/)로 시작해도 됩니다.
	
	@GetMapping("board/detail") //요청
	public String detail(HttpServletRequest request) {
		
		request.setAttribute("board1", board1);
		request.setAttribute("board2", board2);
		
		return "board/detail"; //뷰 리졸버에 의해서 return "/WEB-INF/views/board/detail.jsp"
				//응답 이름만 같지 다름
	}
	
	/*
	 	DI
	 	
	 	1. Dependency Injection
	 	2. 의존성 주입
	 	3. 스프링 컨테이너에 있는 bean을 스프링이 주입하는 방법
	 	4. 방법
	 		1) 필드에 직접 주입
	 		2) 생성자를 이용해서 주입
	 		3) setter를 이용해서 주입
	 	5. @Inject, @Resource, @AutoWired 등의 애너테이션을 이용
	 		그 중 @AutoVired가 가장 널리 사용
	*/
	
	/*
	 	@Autowired
	 	
	 	1. bean의 타입(class)이 일치하는 bean을 찾아서 주입하는 방식
	 	   (주의. bean의 이름(id)을 찾는 방식이 아님)
	 	
	 	2. 필드, 생성자, setter에서 사용
	*/
	
}
