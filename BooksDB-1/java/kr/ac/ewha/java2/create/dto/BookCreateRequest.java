package kr.ac.ewha.java2.create.dto;

import kr.ac.ewha.java2.domain.Book;

public class BookCreateRequest {
	private String isbn;
	private String title;
	private String publisher;
	private int count;
	private String author;
	
	//생성자와 getter, setter
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	
	public Book toEntity() {
		return new Book(isbn, title, publisher, count, author);
	}
}
