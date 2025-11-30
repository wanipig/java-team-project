package kr.ac.ewha.java2.read.service;

import kr.ac.ewha.java2.domain.Book;
import kr.ac.ewha.java2.repository.BookRepository;
import kr.ac.ewha.java2.read.dto.BookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReadService {

    private final BookRepository bookRepository;

    public BookReadService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 전체 조회
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::fromEntity)
                .collect(Collectors.toList());
    }

    // 검색 조회 (도서명/저자)
    public List<BookResponse> searchBooks(String keyword) {
        List<Book> byTitle = bookRepository.findByTitleContaining(keyword);
        List<Book> byAuthor = bookRepository.findByAuthorContaining(keyword);
        
        List<Book> combined = new ArrayList<> (byTitle);
        combined.addAll(byAuthor);
        
        return combined.stream()
                .distinct()
                .map(BookResponse::fromEntity)
                .collect(Collectors.toList());
    }

}
