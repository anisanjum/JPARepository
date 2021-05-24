package com.learn.springbootcrudrepository.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exc, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exc.getLocalizedMessage());
		ErrorResponse errorresponse = new ErrorResponse(410L, details);
		System.out.println("Hello!!!!!!!");
		return new ResponseEntity<>(errorresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorresponse = new ErrorResponse(400L, details);
		System.out.println("Hello Student");
		return new ResponseEntity<>(errorresponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateEntryException.class)
	public final ResponseEntity<Object> handleDuplicateEntryException(DuplicateEntryException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorresponse = new ErrorResponse(405L, details);
		System.out.println("Hello Duplicate Student");
		return new ResponseEntity<>(errorresponse, HttpStatus.BAD_REQUEST);
	}
}
