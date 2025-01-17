package com.groupone.shazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.groupone.shazar.ShazarApplication;
import com.groupone.shazar.model.ChatDataBase;
import com.groupone.shazar.service.ChatDataBaseService;
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

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShazarApplication.class)
public class ChatControllerTests {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ChatDataBaseService chatDataBaseService;
	
	
	@Test
	@WithMockUser(username="matt")
	void when_goToSearch() throws Exception {
		
//when(placeService.findAllPlaces()).thenReturn(expectedPlacesList);
		
		mockMvc.perform(get("/chats"))
				.andExpect(status().isOk())
				.andExpect(view().name("chatList"));
	}
	
	@Test
	@WithMockUser(username="matt")
	void when_goToChat() throws Exception {
		
//when(placeService.findAllPlaces()).thenReturn(expectedPlacesList);
		List<ChatDataBase> cdb = new ArrayList<ChatDataBase>();
		when(chatDataBaseService.findChatMessages("2","2")).thenReturn(cdb);
		
		mockMvc.perform(get("/chats/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("chats"));
	}
}
