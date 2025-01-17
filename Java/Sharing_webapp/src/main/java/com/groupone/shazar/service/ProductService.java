package com.groupone.shazar.service;

import java.util.List;

import com.groupone.shazar.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	
	void saveProduct(Product product);
	
	//List<Product> findByTitleOrDescription(String title, String description);
	Product findByProductId(int productId);

	Product bookProduct(int productId, java.sql.Date startDate, java.sql.Date endDate);

	Product denyProduct(int productId, String denyRequest);

}