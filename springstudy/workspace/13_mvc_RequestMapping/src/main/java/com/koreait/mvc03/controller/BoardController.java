package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 안녕. 나는 Controller야.
@Controller
public class BoardController {

	
	// URLMapping 처리는 메소드가 담당합니다.
	// 모든 메소드는 @RequestMapping 애너테이션을 추가해서 URLMapping을 처리합니다.
	
	
	// 1. 시작 페이지 만들기
	// http://localhost:9090/mvc03/  주소와 연결되는 JSP(index.jsp)를 반환합니다.
	@RequestMapping("/")	// @RequestMapping(value="/")
	public String goIndex() {
		return "index";		// return "/index"; 슬래시(/)로 시작해도 차이가 없습니다.
	}
	
	
	// 2. boardInsertPage.jsp로 이동하기 (단순 이동)
	// http://localhost:9090/mvc03/boardInsertPage  주소와 연결되는 JSP(index.jsp)를 반환합니다.
	@RequestMapping("boardInsertPage")	// @RequestMapping("/boardInsertPage") 슬래시(/)로 시작해도 차이가 없습니다.
	public String boardInsertPage() {
		// return "boardInsertPage";	// return "/WEB-INF/views/boardInsertPage.jsp"; (경로가 안 맞네요.)
		return "board/boardInsertPage";	// return "/WEB-INF/views/board/boardInsertPage.jsp";
	}
	
	
	// 3. boardInsertPage.jsp로 이동하기 (단순 이동)
	// http://localhost:9090/mvc03/a/b/c  주소와 연결되는 JSP(index.jsp)를 반환합니다.
	
	// 매핑값과(/a/b/c) 이동할 경로가 일치할 필요가 없습니다.
	// 외부에서 주소를 이용해 내부 구조를 예상할 수가 없으므로 보안에 도움이 된다.
	
	@RequestMapping("a/b/c")	// @RequestMapping("/a/b/c") 슬래시(/)로 시작해도 차이가 없습니다.
	public String boardInsertPage2() {
		return "board/boardInsertPage";	// return "/board/boardInsertPage"; 슬래시(/)로 시작해도 차이가 없습니다.
	}
	
	// @RequestMapping을 작성할 때 URLMapping값은
	// 슬래시(/)로 시작해도 되고, 없어도 되지만
	// 슬래시(/)를 안 넣는 것으로 연습하겠습니다.
	
}
