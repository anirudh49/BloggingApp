package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.CategoryBO;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.payload.CategoryDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryBO categoryBO;
	
	//create
	@PostMapping("/createCategory")
	public CategoryDTO createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		return categoryBO.createCategory(categoryDTO);
	}
	//update
	@PostMapping("/updateCategory/{categoryId}")
	public CategoryDTO updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable("categoryId") Integer categoryId) throws CategoryNotFoundException {
		return categoryBO.updateCategory(categoryDTO, categoryId);
	}
	//delete
	@DeleteMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		return categoryBO.deleteCategory(categoryId);
	}
	//findByid
	@GetMapping("/findCtgById/{categoryId}")
	public CategoryDTO findCtgById(@PathVariable("categoryId") Integer categoryId) throws CategoryNotFoundException {
		return categoryBO.findById(categoryId);
	}
	//findAll
	@GetMapping("/findAllCatg")
	public List<CategoryDTO> findAllCtgs(){
		return categoryBO.findAll();
	}
}
