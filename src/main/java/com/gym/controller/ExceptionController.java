package com.gym.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.gym.exception.UserNotFoundException;


@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value= UserNotFoundException.class)
	public ResponseEntity<Object> handleNameException(Exception exception){
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}