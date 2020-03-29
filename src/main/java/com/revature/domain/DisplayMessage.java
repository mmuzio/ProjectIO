package com.revature.domain;

public class DisplayMessage {
	
	String messageBody;
	
	String username;

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public DisplayMessage(String messageBody, String username) {
		super();
		this.messageBody = messageBody;
		this.username = username;
	}

	public DisplayMessage() {
		super();
	}
	
	

}
