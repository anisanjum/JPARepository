package com.learn.springbootcrudrepository.exception;

public class StudentNotFoundException extends RuntimeException{

	public static final long serialVersionUID = 1L;
	
	public StudentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
