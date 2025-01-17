package com.groupone.shazar.service;

import java.util.List;

import com.groupone.shazar.model.Product;

public interface SearchService {
	public List<Product> findByUserInput(String searchTerm, String startDate, String endDate,
			String maxPricePerDay, String category, String isDateSearch, String isPriceSearch, String isCategorySearch);
	
	public List<Product> findByKeyword(String keyword);

}
