package com.dmart.exception;

@SuppressWarnings("serial")
public class UserExistException extends RuntimeException{
	public UserExistException() {
		
	}
	
	public UserExistException(String message) {
		super(message);
	}
}
