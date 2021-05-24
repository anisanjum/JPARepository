package com.learn.springbootcrudrepository.exception;

public class DuplicateEntryException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;

	public DuplicateEntryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
