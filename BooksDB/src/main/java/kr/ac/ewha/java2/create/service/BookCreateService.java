package kr.ac.ewha.java2.create.service;

import kr.ac.ewha.java2.domain.Book;
import kr.ac.ewha.java2.create.dto.BookCreateRequest;
import kr.ac.ewha.java2.create.exception.DuplicateIsbnException;
import kr.ac.ewha.java2.create.exception.InvalidStockException;

import org.springframework.stereotype.Service;

import kr.ac.ewha.java2.repository.BookRepository;

@Service //비즈니스 로직 담당
public class BookCreateService {
	private final BookRepository repository; //repository 주입 후(의존성 주입) CRUD 로직 구현
	
	public BookCreateService(BookRepository repository) {
		this.repository = repository;
	}

	//책 create하고 저장
	public Book create(BookCreateRequest request) {
		if(request.getCount()<=0) { //책 수량이 0 이하면 exception!
			throw new InvalidStockException();
		}
		if(repository.existsById(request.getIsbn())) { //ISBN 중복되면 exception!
			throw new DuplicateIsbnException(request.getIsbn());
		}
		
		Book bookToSave = request.toEntity(); //DTO를 DB에 저장할 수 있는 JPA 엔티티 객체로 반환
		return repository.save(bookToSave); //DB에 저장
	}
}
