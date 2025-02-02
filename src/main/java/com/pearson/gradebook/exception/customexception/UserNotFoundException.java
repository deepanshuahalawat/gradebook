package com.pearson.gradebook.exception.customexception;

public class UserNotFoundException extends Exception{
	static final long serialVersionUID = -3387516544124229948L;
	
	private final static String message = "USER NOT FOUND IN DB";
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException() {
		super(message);
	}
	
	
}
