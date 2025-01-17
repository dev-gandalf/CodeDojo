package com.groupone.shazar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.Category;
import com.groupone.shazar.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository repo;

	@Autowired
	public CategoryServiceImpl(CategoryRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return repo.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		repo.save(category);
	}

	
}
