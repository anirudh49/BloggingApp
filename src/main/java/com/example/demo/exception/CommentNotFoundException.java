package com.example.demo.exception;

public class CommentNotFoundException extends Exception{

	public CommentNotFoundException() {
		super();
	}
	
	public CommentNotFoundException(String message) {
		super(message);
	}
}
