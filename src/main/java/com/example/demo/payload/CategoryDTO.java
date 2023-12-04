package com.example.demo.payload;

public class CategoryDTO {

	private int category_id;
	private String category_title;
	private String category_description;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

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

	public CategoryDTO(int category_id, String category_title, String category_description) {
		super();
		this.category_id = category_id;
		this.category_title = category_title;
		this.category_description = category_description;
	}

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
