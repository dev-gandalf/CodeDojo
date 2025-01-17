package com.groupone.shazar.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.groupone.shazar.ShazarApplication;
import com.groupone.shazar.model.Product;
import com.groupone.shazar.service.CategoryServiceImpl;
import com.groupone.shazar.service.ProductServiceImpl;
import com.groupone.shazar.service.SearchServiceImpl;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShazarApplication.class)
public class UploadControllerTests {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ProductServiceImpl productService;
	private CategoryServiceImpl categoryService;
	
	@Test
	@WithMockUser(username="matt")
	void when_GoToUpload() throws Exception {
		
		mockMvc.perform(get("/upload"))
		.andExpect(status().isOk())
		.andExpect(view().name("upload"));
	}
	
	@Test
	@WithMockUser(username="matt")
	void when_pictureUpload() throws Exception {
		Product prod = new Product(); 
		//when(productService.saveProduct(prod)).then()
		
		mockMvc.perform(MockMvcRequestBuilders.multipart("/upload"))
		.andExpect(status().isOk())
		.andExpect(view().name("upload"))
		.andExpect(model().attribute("confirmation", "File successfully uploaded"));
		;
	}
	
}
