package com.groupone.shazar.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import com.groupone.shazar.ShazarApplication;
import com.groupone.shazar.model.User;
import com.groupone.shazar.service.UserServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShazarApplication.class)
public class ProfileControllerTests {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private UserServiceImpl userService;
	
	
	@Test
	@WithMockUser(username="matt")
	void when_GoToProfile() throws Exception {
		String username = "test";
		User testUser = new User();
		testUser.setUsername("test");
		when(userService.getCurrentUser(Mockito.anyString())).thenReturn(testUser);
		mockMvc.perform(get("/profile")
				.param("user", testUser.getUsername()))
				.andExpect(status().isOk())
				.andExpect(view().name("profile"));
	}
	
	@Test
	@WithMockUser(username="matt")
	void when_updateProfile() throws Exception{
		User us = new User();
		us.setUsername("matte");
		mockMvc.perform(post("/profile"))
			.andExpect(model().attribute("user", us))		
			.andExpect(status().isOk())
			.andExpect(view().name("profile"));
	}
}
