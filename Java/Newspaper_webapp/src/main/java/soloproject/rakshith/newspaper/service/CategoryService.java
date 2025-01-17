package soloproject.rakshith.newspaper.service;

import java.util.List;

import soloproject.rakshith.newspaper.model.Category;





public interface CategoryService {
	List<Category> getAllCategories();
	
	void saveCategory(Category category);
}
