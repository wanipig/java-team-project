package kr.ac.ewha.java2.create.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import kr.ac.ewha.java2.create.service.BookCreateService;

@Controller //컨트롤러 계층 객체임을 명시
@RequestMapping("/books") //books로 시작하는 모든 요청 처리 준비 완료
public class BookCreateController {
	private final BookCreateService service; //service 주입
	
	public BookCreateController(BookCreateService service) {
		this.service = service;
	}
	
	@PostMapping("/submitForm")
	@ResponseBody //HTTP 응답의 본문으로 클라이언트에게 직접 전송 지시
	public String create(BookCreateRequest request) {
		service.create(request); //service에게 request 객체 전달하고 DB 저장 작업 위임
		
		return "<h3>도서 등록 완료</h3><a href='/book-index.html'>돌아가기</a>\"";
	}
}
