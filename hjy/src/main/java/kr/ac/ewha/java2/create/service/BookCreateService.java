package kr.ac.ewha.java2.create.service;

import kr.ac.ewha.java2.domain.Book;
import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import kr.ac.ewha.java2.create.exception.DuplicateIsbnException;
import kr.ac.ewha.java2.create.exception.InvalidStockException;

import org.springframework.stereotype.Service;

import kr.ac.ewha.java2.repository.BookRepository;

@Service
public class BookCreateService {
	private final BookRepository repository;
	
	public BookCreateService(BookRepository repository) {
		this.repository = repository;
	}

	public Book create(BookCreateRequest request) {
		if(request.getCount()<=0) {
			throw new InvalidStockException();
		}
		if(repository.existsById(request.getISBN())) {
			throw new DuplicateIsbnException(request.getISBN());
		}
		
		Book bookToSave = request.toEntity();
		return repository.save(bookToSave);
	}
}
