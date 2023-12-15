package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@PostMapping("")
	public Category createCategory(@RequestBody Category category) {

		Category cate = service.createCategory(category);
		
		return category ;
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Integer id) {
		return service.getCategoryById(id);
	}
	@PutMapping()
	public Category updateCategory(@RequestBody Category category) {
		return service.updateCategory(category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory (@PathVariable Integer id) {
		 service.deleteCategoryById(id);
	}
	
	
	@GetMapping
    public Page<Category> getAllCategoriesByPage(@RequestParam(value = "page") int page) {
		 Pageable pageable = PageRequest.ofSize(page);
	        return service.getAllCategoriesByPage(pageable);
    }

}
