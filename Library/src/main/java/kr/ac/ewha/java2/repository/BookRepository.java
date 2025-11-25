package kr.ac.ewha.java2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.ewha.java2.entity.Book;

@Repository //DAO 구현 끝
public interface BookRepository extends JpaRepository<Book, String> {
	//JPARepository<엔티티 타입, 기본 키(ISBN) 타입>
}
