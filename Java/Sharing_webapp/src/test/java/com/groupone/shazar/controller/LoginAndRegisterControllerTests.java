package com.groupone.shazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupone.shazar.ShazarApplication;
import com.groupone.shazar.model.User;
import com.groupone.shazar.security.DefaultUserDetailsService;
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

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShazarApplication.class)
public class LoginAndRegisterControllerTests {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private DefaultUserDetailsService userService;
	
	@Test
	void when_GoToLogin() throws Exception {
		
		mockMvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"));
	}
	
	@Test
	void when_GoToRegistraion() throws Exception {
		
		mockMvc.perform(get("/registration"))
		.andExpect(status().isOk())
		.andExpect(view().name("registration"));
	}
	
	@Test
	@WithMockUser(username="matt")
	void when_GoToRegisterSubmit() throws Exception {
		
		mockMvc.perform(post("/registration"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"));
	}
	
	@Test
	void when_GoToRegisterSubmit_2() throws Exception {

//		when(userService.save(usr)).then
		String passwordConfirmed = "true";
		User usr = new User();		
		
		mockMvc.perform(post("/registration"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"));
	}

}
