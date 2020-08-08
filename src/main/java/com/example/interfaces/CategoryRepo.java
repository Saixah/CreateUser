package com.example.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Category;

public interface CategoryRepo {

	void saveCategory(Category category);
	
	void deleteCategoryById(int id);
	
	List<Category> findAllCategory(int id);
	
	Category findById(int id);
	
	void updateCategory(Category category);
}

