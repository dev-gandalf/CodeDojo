package com.groupone.shazar.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChatDataBase {

	@Id
	@GeneratedValue
	@Column(name = "chat_id")
	int id;
	private String message;
	private String receiver;
	private String sender;
	private Timestamp time;

	public ChatDataBase() {
	}

	public ChatDataBase(String message, String receiver, String sender, Timestamp time) {
		super();
		this.message = message;
		this.receiver = receiver;
		this.sender = sender;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ChatDataBase [id=" + id + ", message=" + message + ", receiver=" + receiver + ", sender=" + sender
				+ ", time=" + time + "]";
	}



}
