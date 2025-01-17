package com.groupone.shazar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.groupone.shazar.model.Product;


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
public class SearchServiceTests {
	
	// Injects the service to be tested
	@InjectMocks
	private SearchServiceImpl searchService;
	
	@MockBean
	private ProductRepository productRepository;
	
	List<Product> expectedProductsList = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		expectedProductsList.add(new Product("tolles Fahrzeug. Neu", "VW Kaefer", "car", 10.50));
		expectedProductsList.add(new Product("toller Traktor. Unbedingt probefahren", "Porsche Traktor", "car", 5.99));
	}
	
//	@Test
//	void whenFindAllProductsListIsReturned(){
//		when(productRepository.findAll()).thenReturn(expectedProductsList);
//		assertEquals(expectedProductsList, searchService.findAll())
//	}
//	
//	@Test
//	void whenSaveProductThenSaveInRepoCalled() {
//		Product product = new Product("hi", null, null, 0);
//		searchService.saveProduct(product);
//		verify(productRepository, times(1)).save(product);
//	}
	
	@Test
	void whenFindByUserInput_textAndDate() {
		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "true", "false", "false");
		verify(productRepository, times(1)).findByTextAndDate(Mockito.anyString(), Mockito.any(java.util.Date.class), Mockito.any(java.util.Date.class)); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
	}
	
//	@Test
//	void whenFindByUserInput_text() {
//		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "true", "false", "false");
//		verify(productRepository, times(1)).findByTextAndDate(Mockito.anyString(), Mockito.any(java.util.Date.class), Mockito.any(java.util.Date.class)); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
//	}
	
	@Test
	void whenFindByUserInput_textAndDateAndCategory() {
		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "true", "false", "true");
		verify(productRepository, times(1)).findByTextAndDateAndCategory(Mockito.anyString(), Mockito.any(java.util.Date.class), Mockito.any(java.util.Date.class), Mockito.anyString()); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
	}
	
	@Test
	void whenFindByUserInput_textAndPriceAndCategory() {
		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "false", "true", "true");
		verify(productRepository, times(1)).findByTextAndPriceAndCategory(Mockito.anyString(), Mockito.anyDouble() ,Mockito.anyString()); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
	}
	
	@Test
	void whenFindByUserInput_textAndCategory() {
		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "false", "false", "true");
		verify(productRepository, times(1)).findByTextAndCategory(Mockito.anyString(), Mockito.anyString()); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
	}
	
	@Test
	void whenFindByUserInput_text() {
		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "false", "false", "false");
		verify(productRepository, times(1)).findByTitleOnly(Mockito.anyString()); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
	}
	
	@Test
	void whenFindByUserInput_textAndDateAndPrice() {
		searchService.findByUserInput("traktor", "2022-05-01", "2022-05-10", "10.99", "car", "true", "true", "false");
		verify(productRepository, times(1)).findByTextAndDateAndPrice(Mockito.anyString(), Mockito.any(java.util.Date.class), Mockito.any(java.util.Date.class), Mockito.anyDouble()); //, Mockito.any(java.util.Date.class),Mockito.any(java.util.Date.class));
	}
	
	@Test
	void whenFindByUserInput_category() {
		searchService.findByUserInput("", "2022-05-01", "2022-05-10", "10.99", "car", "false", "false", "true");
		verify(productRepository, times(1)).findByCategory(Mockito.anyString());
	} 
}
