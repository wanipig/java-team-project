package kr.ac.ewha.java2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //이 클래스를 JPA 관리 객체로 지정- 테이블
@Table(name = "books") //실제 데이터 베이스 테이블 이름과 동일하게 지정
public class Book {
	
	@Id //ISBN 필드를 테이블의 고유 식별자로 지정- 기본 키
	private String ISBN;
	private String title;
	private String publisher;
	private int count;
	private String author;
	
	//생성자
	public Book() {}
	public Book(String ISBN, String title, String publisher, int count, String author) {
		ISBN = ISBN;
		this.title = title;
		this.publisher = publisher;
		this.count = count;
		this.author = author;
	}
	
	//getter, setter
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		ISBN = ISBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
