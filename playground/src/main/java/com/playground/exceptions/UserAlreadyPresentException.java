package com.playground.exceptions;

public class UserAlreadyPresentException extends RuntimeException{
	public UserAlreadyPresentException(String message) {
		super(message);
	}
}
