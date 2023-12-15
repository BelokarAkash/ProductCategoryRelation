package com.exam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exam.entity.Category;
import com.exam.entity.Product;
import com.exam.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;

	public Category createCategory(Category category) {
		return repo.save(category);
	}

	public Category getCategoryById(Integer id) {
		return repo.findById(id).get();
	}


	public Category updateCategory(Category category) {
		
		int categoryId = category.getId();
		Optional<Category> p1 = repo.findById(categoryId);
		if (Objects.isNull(p1)){
			return null;	
		}
		
		return repo.save(category);
	}

	public void deleteCategoryById(Integer id) {
		repo.deleteById(id);
	}

	public Page<Category> getAllCategoriesByPage(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
