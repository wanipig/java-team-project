package kr.ac.ewha.java2.delete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		@GetMapping("/delete")
	    public String showDeleteForm() {
	        return "delete";
	    }
		
			// DELETE 책 삭제 -> ID로 삭제 하기
		@PostMapping("/delete") // POST 요청 "/user/delete" 처리
		public String delete(@RequestParam String isbn) {
			service.delete(isbn);
			
			return "redirect:/books";
		}
}
