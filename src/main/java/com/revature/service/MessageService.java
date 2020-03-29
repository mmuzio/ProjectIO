package com.revature.service;

import java.util.List;

import com.revature.domain.Message;

public interface MessageService {
	
	public void insertMessage(Message message);
	
	public Message getMessageById(Long id);
	
	public List<Message> getMessagesByProject(Long id);
	
	public List<Message> getMessagesByUsername(String username);

	public void deleteMessage(Long id);

	public void updateMessage(Message message);

	public List<Message> getAllMessages();

}
