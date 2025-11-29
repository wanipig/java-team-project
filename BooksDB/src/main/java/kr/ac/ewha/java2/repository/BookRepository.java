package kr.ac.ewha.java2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.ewha.java2.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository //DAO 구현 끝
public interface BookRepository extends JpaRepository<Book, String>{
	//JPARepository<엔티티 타입, 기본 키(ISBN) 타입>
	 Optional<Book> findByISBN(String ISBN);
	 List<Book> findByTitleContaining(String keyword);
	 List<Book> findByAuthorContaining(String keyword);
}
