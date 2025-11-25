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

	public Book create(Book book) {
		return repository.save(book);
	}
}
