package com.example.demo.exception;

public class CategoryNotFoundException extends Exception{

	public CategoryNotFoundException() {
		super();
	}
	
	public CategoryNotFoundException(String message) {
		super(message);
	}
}
