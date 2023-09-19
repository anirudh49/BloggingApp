package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.RespStatus;

@RestControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public RespStatus UserNotFoundExceptionHandler(UserNotFoundException exception) {
		RespStatus respStatus = new RespStatus();
		respStatus.setStatus("Exception occured");
		respStatus.setMessage("User by this id doesn't exist.");
		return respStatus;
	}
}
