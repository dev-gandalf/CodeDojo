package com.groupone.shazar.model;

public class Greeting {

	private String content;
	private String sender;

	public Greeting() {
	}

	public Greeting(String content, String sender) {
		this.content = content;
		this.sender = sender;
	}

	public String getSender() {
		return sender;
	}

	public String getContent() {
		return content;
	}


}
