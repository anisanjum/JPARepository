package com.learn.springbootcrudrepository.exception;

import java.util.List;

public class ErrorResponse {

	Long errorCode;
	List<String> errorMessage;
	
	public ErrorResponse(Long errorCode, List<String> errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}
		
}
