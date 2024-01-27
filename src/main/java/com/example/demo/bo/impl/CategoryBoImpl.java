package com.example.demo.bo.impl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.CategoryBO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.entities.Category;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.payload.CategoryDTO;

@Service
public class CategoryBoImpl implements CategoryBO {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		return entityToDTO(categoryDAO.save(dtoToEntity(categoryDTO)));
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, int categoryId) throws CategoryNotFoundException {
		try {
		Category category = categoryDAO.findById(categoryId).get();
		category.setCategory_id(categoryDTO.getCategory_id());
		category.setCategory_title(categoryDTO.getCategory_title());
		category.setCategory_description(categoryDTO.getCategory_description());
		categoryDAO.save(category);
		return entityToDTO(category);
		}
		catch (Exception e) {
			throw new CategoryNotFoundException("Invalid Category Id..");
		}
	}

	@Override
	public String deleteCategory(int categoryId) {
		categoryDAO.deleteById(categoryId);
		return "Category has been deleted";
	}

	@Override
	public CategoryDTO findById(int categoryId) throws CategoryNotFoundException {
		try {
		Category category = categoryDAO.findById(categoryId).get();
		return entityToDTO(category);
		}
		catch(Exception e) {
			throw new CategoryNotFoundException("Invalid Category Id..");
		}
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<Category> categories = new ArrayList<>();
		categories = categoryDAO.findAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(int i=0;i<categories.size();i++) {
			categoryDTOs.add(entityToDTO(categories.get(i)));
		}
		return categoryDTOs;
	}
	
	CategoryDTO entityToDTO(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
	
	Category dtoToEntity(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}



	

}
