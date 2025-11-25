package kr.ac.ewha.java2.create.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import kr.ac.ewha.java2.create.service.BookCreateService;
import kr.ac.ewha.java2.domain.Book;

@RestController
@RequestMapping("/books")
public class BookCreateController {
	private final BookCreateService bookCreateService;
	
	public BookCreateController(BookCreateService bookCreateService) {
		this.bookCreateService = bookCreateService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Book> create(@RequestBody BookCreateRequest request){
		Book createdBook = bookCreateService.create(request);
		
		return ResponseEntity.status(201).body(createdBook);
	}
	
	
}
