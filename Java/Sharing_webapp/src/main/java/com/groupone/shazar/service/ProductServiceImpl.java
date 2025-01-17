package com.groupone.shazar.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.Product;
import com.groupone.shazar.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	private ProductRepository repo;


	@Autowired
	public ProductServiceImpl(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		repo.save(product);
	}

	@Override
	public Product findByProductId(int productId) {
		Optional<Product> byId = repo.findById(productId);
		Product productById = byId.get();
		return productById;
	}


	@Override
	public Product bookProduct(int productId, java.sql.Date startDate, java.sql.Date endDate) {

		Optional<Product> byId = repo.findById(productId);
		//TODO: add exception
		Product bookproduct = null;

		if (byId.isPresent()) {
			bookproduct = byId.get();
			boolean isrequest = bookproduct.isRequestproduct();
			boolean isaccept = bookproduct.isAcceptrequest();

			if (isrequest == false && isaccept == false) {
				bookproduct.setRequestproduct(true);
				bookproduct.setStartDate(startDate);
				bookproduct.setEndDate(endDate);
				bookproduct.setBorrowerUsername(SecurityContextHolder.getContext().getAuthentication().getName());
				repo.saveAndFlush(bookproduct);

				return bookproduct;
			}


			if (isrequest == true && isaccept == false) {
				bookproduct.setRequestproduct(true);
				bookproduct.setAcceptrequest(true);
				bookproduct.setStartDate(startDate);
				bookproduct.setEndDate(endDate);
				//bookproduct.setOwnerId(User.id);
				repo.saveAndFlush(bookproduct);

				return bookproduct;
			}


		}
		// possibly null
		return bookproduct;

	}

	
	@Override
	public Product denyProduct(int productId, String denyRequest) {
		Optional<Product> byId = repo.findById(productId);
		//TODO: add exception
		Product bookproduct = null;
		
		if (byId.isPresent()) {
			bookproduct = byId.get();
			bookproduct.setBorrowerUsername(null);
			bookproduct.setStartDate(null);
			bookproduct.setAcceptrequest(false);
			bookproduct.setRequestproduct(false);
			bookproduct.setEndDate(null);
			bookproduct.setOwnerUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			repo.saveAndFlush(bookproduct);
		}
		return bookproduct;
	}
	
}