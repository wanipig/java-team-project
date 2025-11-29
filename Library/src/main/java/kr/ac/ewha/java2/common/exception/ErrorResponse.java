package kr.ac.ewha.java2.common.exception;

//에러 메세지를 전달하기 위한 클래스
public class ErrorResponse {
	
	private final String message;
	private final String errorCode;
	
	public ErrorResponse(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	
}
