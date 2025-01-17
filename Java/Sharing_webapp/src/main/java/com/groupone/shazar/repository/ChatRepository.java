package com.groupone.shazar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupone.shazar.model.ChatDataBase;

@Repository
public interface ChatRepository extends JpaRepository<ChatDataBase, Integer> {

	@Query("select c from ChatDataBase c where (c.sender = ?1 or c.receiver = ?1) and (c.sender = ?2 or c.receiver = ?2)")
	List<ChatDataBase> findChatMessages(String receiver, String sender);

	@Query("select c from ChatDataBase c where c.sender = ?1 or c.receiver = ?1")
	List<ChatDataBase> findAllChatMessages(String username);

}

