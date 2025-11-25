package kr.ac.ewha.java2.create.service;

import kr.ac.ewha.java2.domain.Book;
import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.ewha.java2.repository.BookRepository;

@Service
public class BookCreateService {
	private final BookRepository repository;
	
	public BookCreateService(BookRepository repository) {
		this.repository = repository;
	}

	//DTO를 입력받고 Book 엔티티를 반환하도록 수정
	public Book create(BookCreateRequest request) {
		Book bookToSave = request.toEntity();
		return repository.save(bookToSave);
	}
}
