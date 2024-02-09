package com.example.demo.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.RespStatus;

@RestControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public RespStatus userNotFoundExceptionHandler(UserNotFoundException exception) {
		RespStatus respStatus = new RespStatus();
		respStatus.setStatus("Exception occured");
		respStatus.setMessage("User by this id doesn't exist.");
		return respStatus;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public RespStatus methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
		RespStatus respStatus = new RespStatus();
		respStatus.setStatus("Exception occured");
		respStatus.setMessage("Entered values are not correct/not in proper format.");
		return respStatus;
		
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public RespStatus categoryNotFoundExceptionHandler(CategoryNotFoundException exception) {
		RespStatus respStatus = new RespStatus();
		respStatus.setStatus("Exception occured");
		respStatus.setMessage("Category by this id doesn't exist.");
		return respStatus;
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public RespStatus postNotFoundExceptionHandler(PostNotFoundException exception) {
		RespStatus respStatus = new RespStatus();
		respStatus.setStatus("Exception occured");
		respStatus.setMessage("Post by this id doesn't exist.");
		return respStatus;
	}
	
	@ExceptionHandler(CommentNotFoundException.class)
	public RespStatus commentNotFoundExceptionHandler(CommentNotFoundException exception) {
		RespStatus respStatus = new RespStatus();
		respStatus.setStatus("Exception occured");
		respStatus.setMessage("Comment by this id doesn't exist.");
		return respStatus;
	}
}
