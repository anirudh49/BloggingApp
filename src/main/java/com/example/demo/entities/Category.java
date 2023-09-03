package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

	@Id
	private int category_id;
	private String title;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category(int category_id, String title) {
		super();
		this.category_id = category_id;
		this.title = title;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
