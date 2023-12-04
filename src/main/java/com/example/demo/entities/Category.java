package com.example.demo.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int category_id;
	@NotBlank
	private String category_title;
	@NotBlank
	@Length(min = 4,max = 200)
	private String category_description;


	public String getCategory_title() {
		return category_title;
	}

	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public Category(int category_id, String category_title, String category_description) {
		super();
		this.category_id = category_id;
		this.category_title = category_title;
		this.category_description = category_description;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}