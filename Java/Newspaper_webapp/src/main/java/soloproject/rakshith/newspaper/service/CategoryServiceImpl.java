package soloproject.rakshith.newspaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public List<Category> getAllCategories() {
		return repo.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		repo.save(category);
		
	}

	
}
