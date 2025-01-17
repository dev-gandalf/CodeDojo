package com.groupone.shazar.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.groupone.shazar.ShazarApplication;
import com.groupone.shazar.model.Product;
import com.groupone.shazar.model.User;
import com.groupone.shazar.service.ProductServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShazarApplication.class)
public class DetailsControllerTests {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private ProductServiceImpl productService;

	@Test
	@WithMockUser(username="matt")
	void when_goToDetails() throws Exception {
		Product prod = new Product();
		prod.setTitle("neues Produkt");
		prod.setDescription("neue Beschreibung");

		User user = new User();
		user.setUsername("matt");

		when(productService.findByProductId(1)).thenReturn(prod);

		mockMvc.perform(get("/details/1"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("product", prod))
		.andExpect(model().attribute("user", user))
		.andExpect(view().name("details"));
	}

	@Test
	@WithMockUser(username="matt")
	void when_SendRequest() throws Exception {
		Product prod = new Product();
		prod.setTitle("neues Produkt");
		prod.setDescription("neue Beschreibung");
		java.sql.Date sDate = new java.sql.Date(2022-01-02);
		java.sql.Date eDate = new java.sql.Date(2022-02-02);

		when(productService.bookProduct(1, sDate, eDate)).thenReturn(prod);

		mockMvc.perform(post("/details/1")
				.param("productId", "1")
				.param("startDate", "2022-01-02")
				.param("endDate", "2022-02-02"))
		.andExpect(status().isOk())
		//.andExpect(model().attribute("product", product))
		.andExpect(view().name("details"));
	}

	@Test
	@WithMockUser(username = "matt")
	void when_SendRequest_Post_no() throws Exception {
		Product prod = new Product();
		prod.setTitle("neues Produkt");
		prod.setDescription("neue Beschreibung");
		java.sql.Date sDate = new java.sql.Date(2022 - 01 - 02);
		java.sql.Date eDate = new java.sql.Date(2022 - 02 - 02);

		when(productService.bookProduct(1, sDate, eDate)).thenReturn(prod);

		mockMvc.perform(post("/details/no/1").param("productId", "1").param("startDate", "2022-01-02").param("endDate",
				"2022-02-02")).andExpect(status().isOk())
				// .andExpect(model().attribute("product", product))
				.andExpect(view().name("details"));
	}

}
