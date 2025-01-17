package com.groupone.shazar.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.groupone.shazar.model.Product;
import com.groupone.shazar.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ProductServiceTests {
	Product sampleProduct;
	Optional<Product> optionalProduct;
	@InjectMocks
	private ProductServiceImpl productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@BeforeEach
	void setUp() {
		sampleProduct = new Product();
		sampleProduct.setTitle("neues Produkt");
		sampleProduct.setDescription("Beschreibung des neuen Produkts");
		sampleProduct.setKeyword("keyword string");
		
		optionalProduct = Optional.of(sampleProduct);
		
	}
	
	@Test
	void when_getAllProducts() {
		productService.getAllProducts();
		verify(productRepository, times(1)).findAll();
	}
	
	@Test
	void when_saveProduct() {
		Product product = new Product();
		product.setTitle("neues Produkt");
		product.setDescription("Beschreibung des neuen Produkts");
		product.setKeyword("keyword string");
		
		productService.saveProduct(product);
		verify(productRepository, times(1)).save(Mockito.any(Product.class));
	}
	
	@Test
	void when_bookProduct_then_returnBook() {
		int productId = 1;
		java.sql.Date startDate = Date.valueOf("2022-01-04");
		java.sql.Date endDate = Date.valueOf("2022-01-10");
		 
		productService.bookProduct(productId, startDate, endDate);
		Optional<Product> byId = optionalProduct;
		when(productRepository.findById(productId)).thenReturn(byId);
		verify(productRepository, times(1)).findById(Mockito.anyInt());
//		verify(productRepository, times(1)).saveAndFlush(Mockito.any(Product.class));
	}
	
	@Test
	void when_findByProductId() {
		int productId = 1;
		productService.findByProductId(productId);
		verify(productRepository, times(1)).findById(Mockito.anyInt());
	}
}
