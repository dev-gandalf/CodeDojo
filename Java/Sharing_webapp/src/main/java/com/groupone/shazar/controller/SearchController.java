package com.groupone.shazar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupone.shazar.model.Category;
import com.groupone.shazar.service.CategoryService;
import com.groupone.shazar.service.ProductService;
import com.groupone.shazar.service.SearchService;



@Controller

public class SearchController {

	//private ProductService productService;
	private SearchService searchService;
	private ProductService productService;
	private CategoryService categoryService;

	@Autowired
	public SearchController(SearchService searchService, ProductService productService, CategoryService categoryService) { // User Details service
		this.searchService = searchService;
		this.productService = productService;
		this.categoryService = categoryService;


		if(categoryService.getAllCategories().size()<=4) {
			Category c = new Category();
			c.setTitle("electronics");
			categoryService.saveCategory(c);

			c = new Category();
			c.setTitle("entertainment");
			categoryService.saveCategory(c);

			c = new Category();
			c.setTitle("vehicle");
			categoryService.saveCategory(c);

			c = new Category();
			c.setTitle("furniture");
			categoryService.saveCategory(c);
		}

	}


	@GetMapping("/search")
	public String goToSearch(ModelMap model) {

		List<Category> categories =  categoryService.getAllCategories();

		model.addAttribute("categories", categories);
		return "search";
	}

	@PostMapping("/search")
	public String goToSearchPage(
			ModelMap model,
			@RequestParam String keyword,
			@RequestParam(value="startDate", defaultValue="") String startDate,
			@RequestParam(value="endDate", defaultValue="") String endDate,
			@RequestParam(value="maxPrice", defaultValue="") String maxPrice,
			@RequestParam(value = "category", defaultValue="") String category,
			@RequestParam(value="isDateSearch", required=false, defaultValue="false") String isDateSearch,
			@RequestParam(value="isPriceSearch", required=false, defaultValue="false") String isPriceSearch,
			@RequestParam(value="isCategorySearch",required=false, defaultValue="false") String isCategorySearch){

		model.addAttribute("products", searchService.findByUserInput(
				keyword,
				startDate,
				endDate,
				maxPrice,
				category,
				isDateSearch,
				isPriceSearch,
				isCategorySearch));
		System.out.println("isPriceSearch: ------" +isPriceSearch);
		System.out.println("isCategorySearch: ------" +isCategorySearch);
		model.addAttribute("keyword", keyword);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("isDateSearch", isDateSearch);
		model.addAttribute("isPriceSearch", isPriceSearch);
		model.addAttribute("isCategorySearch", isCategorySearch);
		model.addAttribute("category", category);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "search";
	}


}
