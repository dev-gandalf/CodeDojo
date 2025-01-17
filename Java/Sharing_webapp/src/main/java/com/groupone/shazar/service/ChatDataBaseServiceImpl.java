package com.groupone.shazar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.ChatDataBase;
import com.groupone.shazar.repository.ChatRepository;

@Service
public class ChatDataBaseServiceImpl implements ChatDataBaseService {

	private ChatRepository repo;

	@Autowired
	public ChatDataBaseServiceImpl(ChatRepository repo) {
		this.repo = repo;
	}

	@Override
	public void saveChatDataBase(ChatDataBase chatDataBase) {
		repo.save(chatDataBase);

	}

	@Override
	public List<ChatDataBase> findChatMessages(String sender, String receiver) {

		return repo.findChatMessages(receiver, sender);
	}

	@Override
	public List<ChatDataBase> findAllChatMessages(String username) {

		return repo.findAllChatMessages(username);
	}


}
