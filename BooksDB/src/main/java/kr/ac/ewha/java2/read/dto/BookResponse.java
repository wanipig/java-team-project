package kr.ac.ewha.java2.read.dto;
import kr.ac.ewha.java2.domain.Book;

public class BookResponse {
    private String ISBN;
    private String title;
    private String publisher;
    private int count;
    private String author;

    public BookResponse(String ISBN, String title, String publisher, int count, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.count = count;
        this.author = author;
    }
    public static BookResponse fromEntity(Book book) {
        return new BookResponse(
            book.getISBN(),
            book.getTitle(),
            book.getPublisher(),
            book.getCount(),
            book.getAuthor()
        );
    }
    
 // Getter
    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getPublisher() { return publisher; }
    public int getCount() { return count; }
    public String getAuthor() { return author; }
}
