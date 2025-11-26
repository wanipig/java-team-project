package kr.ac.ewha.java2.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // DB 연결 실패 / SQL 오류
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse("FRM-E-001", "시스템 오류가 발생했습니다: " + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ISBN 중복
    @ExceptionHandler(kr.ac.ewha.java2.create.exception.DuplicateIsbnException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateIsbn(Exception ex) {
        ErrorResponse error = new ErrorResponse("FRM-V-001", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 재고 음수
    @ExceptionHandler(kr.ac.ewha.java2.create.exception.InvalidStockException.class)
    public ResponseEntity<ErrorResponse> handleInvalidStock(Exception ex) {
        ErrorResponse error = new ErrorResponse("FRM-V-002", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // 도서 없음
    @ExceptionHandler(kr.ac.ewha.java2.delete.exception.BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(Exception ex) {
        ErrorResponse error = new ErrorResponse("FRM-E-002", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
