package com.groupone.shazar.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.Product;
import com.groupone.shazar.repository.ProductRepository;

@Service
public class SearchServiceImpl implements SearchService {
	private ProductRepository repo;
	
	@Autowired
	public SearchServiceImpl(ProductRepository repo) {
		this.repo = repo;
	}		
	
	@Override
	public List<Product> findByKeyword(String keyword) {
		List<Product> filteredByKeyword = repo.findByKeywordContainsIgnoreCase(keyword);
		filteredByKeyword.addAll(repo.findByTitleContainsIgnoreCase(keyword));
		
		return filteredByKeyword;
	}
	
	@Override
	public List<Product> findByUserInput(
			String searchTerm, 
			String startDate, 
			String endDate,
			String maxPricePerDay, 
			String category,
			String isDateSearch, 
			String isPriceSearch, 
			String isCategorySearch) {
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
		boolean isDate = Boolean.parseBoolean(isDateSearch);
		boolean isPrice = Boolean.parseBoolean(isPriceSearch);
		boolean isCategory = Boolean.parseBoolean(isCategorySearch);
		boolean isText = (searchTerm.length()!= 0);
		
		System.out.println("isDate aktiv: " + isDate);
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		
		
		// Text, Date, Price, Category
		if(isText && isDate && isPrice) {
			try {
				return repo.findByTextAndDateAndPrice(
						searchTerm, 
						format.parse(startDate), 
						format.parse(endDate), 
						Double.parseDouble(maxPricePerDay));
				
			} catch (ParseException e) {
				e.printStackTrace(); 
			}
		}
		
		if(isText && isPrice && !isCategory && !isDate) {
			return repo.findByTextAndPrice(searchTerm, Double.parseDouble(maxPricePerDay));
		}
		
		if(isText && isPrice && isCategory && !isDate) {
			return repo.findByTextAndPriceAndCategory(searchTerm, Double.parseDouble(maxPricePerDay), category);
		}
		
		if(isText && isDate && !isPrice && !isCategory) {
			try {
				return repo.findByTextAndDate(searchTerm, format.parse(startDate), format.parse(endDate));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(isText && isDate &&isCategory && !isPrice ) {
			try {
				return repo.findByTextAndDateAndCategory(searchTerm, format.parse(startDate), format.parse(endDate), category);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(isText && !isDate && !isPrice && !isCategory) {
			List<Product> pList = repo.findByTitleOnly(searchTerm);
			return pList;
		}

		if(isCategory && !isText && !isDate && !isPrice) {
			
			return repo.findByCategory(category);
		}
		
		
		if(isText && isCategory) {
			return repo.findByTextAndCategory(searchTerm, category);
		}
		return null;

	}
}

