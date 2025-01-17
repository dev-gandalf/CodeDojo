package com.groupone.shazar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.groupone.shazar.model.ChatDataBase;
import com.groupone.shazar.model.Greeting;
import com.groupone.shazar.service.ChatDataBaseService;


@Controller
public class ChatController {


	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private ChatDataBaseService chatDataBaseService;

	//	@MessageMapping("/hello")
	//	@SendTo("/topic/greetings")
	//	public Greeting greeting(HelloMessage message) throws Exception {
	//
	//		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	//	}


	@MessageMapping("/private")
	public void sendToSpecificUser(@Payload ChatDataBase message) {

		Greeting greeting = new Greeting(message.getMessage(), message.getSender());
		simpMessagingTemplate.convertAndSendToUser(message.getReceiver(), "/specific", greeting);

		chatDataBaseService.saveChatDataBase(message);

	}


	@GetMapping("/chats")
	public String goToSearch(ModelMap model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		List<ChatDataBase> chatList = chatDataBaseService.findAllChatMessages(username);

		List<String> displayChatMessages = new ArrayList<>();

		for (ChatDataBase chat : chatList) {
			if (chat.getSender().equals(username)) {
				displayChatMessages.add(chat.getReceiver());
			}
			else {
				displayChatMessages.add(chat.getSender());
			}
		}

		displayChatMessages = displayChatMessages.stream().distinct().collect(Collectors.toList());

		model.addAttribute("allChats", displayChatMessages);


		return "chatList";
	}

	@GetMapping("/chats/{receiver}")
	public String goToChat(ModelMap model, @PathVariable String receiver) {

		String sender = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("receiver", receiver); 

		model.addAttribute("sender", sender);

		List<ChatDataBase> allChatMessages = chatDataBaseService.findChatMessages(sender, receiver);

		Collections.reverse(allChatMessages);

		model.addAttribute("messages", allChatMessages);

		return "chats";
	}


}


