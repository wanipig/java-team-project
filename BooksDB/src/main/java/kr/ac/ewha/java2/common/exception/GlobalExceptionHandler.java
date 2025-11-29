package kr.ac.ewha.java2.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.ac.ewha.java2.create.exception.DuplicateIsbnException;
import kr.ac.ewha.java2.create.exception.InvalidStockException;

@RestControllerAdvice //모든 컨트롤러에서 발생하는 예외를 여기서 처리하도록 지정
public class GlobalExceptionHandler {
	
	// DB 연결 실패 / SQL 오류
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse("FRM-E-001", "시스템 오류가 발생했습니다: " + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	//ISBN 중복 확인
	@ExceptionHandler(DuplicateIsbnException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateIsbnException(DuplicateIsbnException e){
		ErrorResponse response = new ErrorResponse(e.getMessage(), "ISBN_DUPLICATE");
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	// 재고 수량 오류 예외 처리
    @ExceptionHandler(InvalidStockException.class)
    public ResponseEntity<ErrorResponse> handleInvalidStockException(InvalidStockException e) {
        // HTTP 400 Bad Request (잘못된 요청) 상태 코드를 사용하여 클라이언트의 요청이 잘못되었음을 알림
        ErrorResponse response = new ErrorResponse(e.getMessage(), "INVALID_INPUT");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
  
 // 도서 없음
    /*@ExceptionHandler(kr.ac.ewha.java2.delete.exception.BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(Exception ex) {
        ErrorResponse error = new ErrorResponse("FRM-E-002", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }*/
    
}