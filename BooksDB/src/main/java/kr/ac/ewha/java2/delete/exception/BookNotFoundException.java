package kr.ac.ewha.java2.delete.exception;

public class BookNotFoundException extends RuntimeException{
	// 1. 기본 생성자
    public BookNotFoundException() {
        super("책을 찾을 수 없습니다."); // 기본 메시지 설정
    }

    // 2. 예외 메시지를 전달받는 생성자 (가장 흔하게 사용)
    public BookNotFoundException(String message) {
        super(message);
    }

    // 3. 메시지와 함께 예외의 '원인(cause)'을 전달받는 생성자
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // 4. 예외의 '원인(cause)'만 전달받는 생성자
    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
