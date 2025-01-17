package com.groupone.shazar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.groupone.shazar.model.Category;
import com.groupone.shazar.model.Picture;
import com.groupone.shazar.repository.CategoryRepository;
import com.groupone.shazar.repository.PictureRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CategoryServiceTests {
	@InjectMocks
	private CategoryServiceImpl categoryService;
	
	@MockBean
	private CategoryRepository categoryRepository;
	
	@BeforeEach
	void setUp() {
		System.out.println("test");
	}
	
	@Test
	void when_getAllCategories() {
		categoryService.getAllCategories();
		verify(categoryRepository, times(1)).findAll();
	}
	
	@Test
	void when_saveCategory() {
		Category category = new Category();
		category.setTitle("test");
		
		categoryService.saveCategory(category);
		verify(categoryRepository, times(1)).save(Mockito.any(Category.class));
	}
}
