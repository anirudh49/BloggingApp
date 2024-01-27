package com.example.demo.exception;

public class PostNotFoundException extends Exception{

	public PostNotFoundException(){
		super();
	}
	
	public PostNotFoundException(String message){
		super("message");
	}
}
