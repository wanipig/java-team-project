package kr.ac.ewha.java2.create.exception;

public class DuplicateIsbnException extends RuntimeException{
	public DuplicateIsbnException(String isbn) {
		super("ISBN [" + isbn + "]은 이미 등록된 도서입니다.");
	}
}
