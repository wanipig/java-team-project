package kr.ac.ewha.java2.create.exception;

public class InvalidStockException extends RuntimeException{
	public InvalidStockException() {
		super("도서 재고 수량은 1권 이상이어야 합니다.");
	}
}