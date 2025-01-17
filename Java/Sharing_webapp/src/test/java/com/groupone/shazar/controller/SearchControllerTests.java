package com.groupone.shazar.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.groupone.shazar.ShazarApplication;
import com.groupone.shazar.model.Product;
import com.groupone.shazar.service.SearchServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShazarApplication.class)
public class SearchControllerTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private SearchServiceImpl searchService;
	
	List<Product> expectedProductsList = new ArrayList<>();
	
	@Test
	void whenGoToSearch() throws Exception {
		
		mockMvc.perform(post("/search")
		.param("keyword","asdf")
		.param("isDateSearch","false")
		.param("startDate","2022-01-02")
		.param("endDate","2022-01-06")
		.param("isPriceSearch","max-price")
		.param("maxPrice", "2.0")
		.param("isCategorySearch","category"))
		.andExpect(status().isOk())
		.andExpect(view().name("search"));
	}
	
	@Test
	void when_getGoToSearch() throws Exception {
		mockMvc.perform(get("/search"))
		.andExpect(status().isOk())
		.andExpect(view().name("search"));
	}
	
	
}
