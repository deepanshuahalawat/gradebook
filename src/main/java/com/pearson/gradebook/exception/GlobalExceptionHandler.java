package com.pearson.gradebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pearson.gradebook.exception.customexception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserNotFoundException> handleUserNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<UserNotFoundException>(exception,HttpStatus.NOT_FOUND);
	}
}
