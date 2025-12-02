package kr.ac.ewha.java2.delete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.ewha.java2.delete.service.BookDeleteService;

@Controller
@RequestMapping("/books")
public class BookDeleteController {
	// 비즈니스 로직처리 서비스 객체
		private final BookDeleteService service;
		// 생성자
		public BookDeleteController(BookDeleteService service) {
			this.service= service;
		}
		
		//1) 삭제 폼 화면(GET)
		@GetMapping("/delete")
	    public String showDeleteForm(Model model) {
			model.addAttribute("targetIsbn", "");
	        return "delete";
	    }
		
		//2) 실제 삭제 처리(POST)
		@PostMapping("/delete")
		@ResponseBody
		public String delete(@RequestParam("isbn") String isbn) {
			service.delete(isbn);
			boolean success = service.delete(isbn);
	        if (!success) {
	            return "<h3>삭제 실패: 도서를 찾을 수 없습니다.</h3><a href='/books'>전체 목록 보기</a>";
	        }
	        return "<h3>삭제 완료</h3><a href='/books'>전체 목록 보기</a>";
		}
}
