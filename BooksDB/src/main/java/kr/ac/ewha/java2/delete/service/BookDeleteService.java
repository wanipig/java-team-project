package kr.ac.ewha.java2.delete.service;

import org.springframework.stereotype.Service;

import kr.ac.ewha.java2.delete.exception.BookNotFoundException;
import kr.ac.ewha.java2.repository.BookRepository;

@Service // 이 클래스가 Spring의 서비스 컴포넌트임을 나타냄 (비즈니스 로직 담당)
public class BookDeleteService {
	private final BookRepository repository;
	
	public BookDeleteService(BookRepository repository) {
		this.repository = repository;
	}
	
	
	//Delete
	public void delete(String isbn) {
		if(!repository.existsById(isbn)) { // 존재여부 체크
			throw new BookNotFoundException("ISBN [" + isbn + "]에 해당하는 도서를 찾을 수 없습니다.");
		}
		repository.deleteById(isbn);
	}
	
	/*public BookResponse searchByIsbn(String isbn) {
	    return repository.findById(isbn)
	            .map(BookResponse::fromEntity)
	            .orElse(null);
	}*/

}
