package com.cov.exception;

public class InvalidEmployeeIdException extends Exception {

	public InvalidEmployeeIdException() {
		super();
		
	}

	public InvalidEmployeeIdException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidEmployeeIdException(String message) {
		super(message);
		
	}

	public InvalidEmployeeIdException(Throwable cause) {
		super(cause);
		
	}

	
}
