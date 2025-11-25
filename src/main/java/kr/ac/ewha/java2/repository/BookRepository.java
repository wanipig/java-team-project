package kr.ac.ewha.java2.repository;

import kr.ac.ewha.java2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
    List<Book> findByTitleContaining(String keyword);
    List<Book> findByAuthorContaining(String keyword);
}

