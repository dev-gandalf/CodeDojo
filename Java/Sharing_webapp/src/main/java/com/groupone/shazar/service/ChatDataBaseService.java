package com.groupone.shazar.service;

import java.util.List;

import com.groupone.shazar.model.ChatDataBase;

public interface ChatDataBaseService {

	void saveChatDataBase(ChatDataBase chatDataBase);

	List<ChatDataBase> findChatMessages(String sender, String receiver);

	List<ChatDataBase> findAllChatMessages(String username);
}
