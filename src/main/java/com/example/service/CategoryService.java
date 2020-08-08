package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CategoryDao;
import com.example.interfaces.CategoryRepo;
import com.example.model.Category;

@Service("categoryService")
@Transactional
public class CategoryService implements CategoryRepo{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryDao.deleteCategoryById(id);
		
	}

	@Override
	public List<Category> findAllCategory(int id) {
		return categoryDao.findAllCategory(id);
	}

	@Override
	public Category findById(int id) {
		return categoryDao.findById(id);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
		
	}

}
