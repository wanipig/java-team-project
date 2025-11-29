package kr.ac.ewha.java2.create.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/new") //이 경로가 index.html의 /books/new 요청을 받음
    public String showCreateForm() {
        // 이 메서드는 templates 폴더 내의 create.html 템플릿 파일을 반환
        return "create"; 
    }
	
	@PostMapping
	public String create(BookCreateRequest request) {
		service.create(request); //service에게 request 객체 전달하고 DB 저장 작업 위임
		
		return "redirect:/books";
	}
}
