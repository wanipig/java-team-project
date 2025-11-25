package kr.ac.ewha.java2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Book {

	@Id
    @Column(length = 50, nullable = false)
    private String isbn;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int count;

    @Column(length = 50, nullable = false)
    private String author;

    // 전체 필드 생성자
    public Book(String isbn, String title, String publisher, int count, String author) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.count = count;
        this.author = author;
    }

    // Getter & Setter
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}
}
