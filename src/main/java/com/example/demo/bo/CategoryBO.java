package com.example.demo.bo;

import java.util.List;

import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.payload.CategoryDTO;

public interface CategoryBO {

	//create
	CategoryDTO createCategory(CategoryDTO categoryDTO);
	//update
	CategoryDTO updateCategory(CategoryDTO categoryDTO, int categoryId) throws CategoryNotFoundException;
	//delete
	String deleteCategory(int categoryId);
	//findbyid
	CategoryDTO findById(int categoryId) throws CategoryNotFoundException;
	//findall
	List<CategoryDTO> findAll();
	
}
