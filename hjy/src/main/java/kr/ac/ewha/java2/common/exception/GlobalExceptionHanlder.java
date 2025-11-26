package kr.ac.ewha.java2.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.ac.ewha.java2.create.exception.DuplicateIsbnException;
import kr.ac.ewha.java2.create.exception.InvalidStockException;

@RestControllerAdvice //모든 컨트롤러에서 발생하는 예외를 여기서 처리하도록 지정
public class GlobalExceptionHanlder {
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
}
