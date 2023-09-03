package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

	@Id
	private int comment_id;
	private String content;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Comment(int comment_id, String content) {
		super();
		this.comment_id = comment_id;
		this.content = content;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
