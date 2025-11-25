package kr.ac.ewha.java2.create.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import kr.ac.ewha.java2.create.service.BookCreateService;
import kr.ac.ewha.java2.domain.Book;

@Controller
@RequestMapping("/books")
public class BookCreateController {
	private final BookCreateService service;
	
	public BookCreateController(BookCreateService service) {
		this.service = service;
	}
	
	@PostMapping("/submitForm")
	@ResponseBody
	public String create(@RequestParam("ISBN") String ISBN,
			@RequestParam("title") String title,
			@RequestParam("publisher") String publisher,
			@RequestParam("count") int count,
			@RequestParam("author") String author) {
		BookCreateRequest request = new BookCreateRequest();
		request.setISBN(ISBN);
		request.setTitle(title);
		request.setPublisher(publisher);
		request.setCount(count);
		request.setAuthor(author);
		
		service.create(request);
		
		return "<h3>도서 등록 완료</h3><a href='/book-crud.html'>돌아가기</a>\"";
	}
	
	
}
