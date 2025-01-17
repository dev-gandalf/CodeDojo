package com.groupone.shazar.service;

import java.util.List;



import com.groupone.shazar.model.Category;

public interface CategoryService {
	List<Category> getAllCategories();
	
	void saveCategory(Category category);
}
