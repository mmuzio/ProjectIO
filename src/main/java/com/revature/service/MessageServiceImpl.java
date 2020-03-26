package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.domain.Message;
import com.revature.domain.Project;
import com.revature.domain.User;
import com.revature.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	private MessageRepository messageRepository;
	
	@Autowired
	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public Message getMessageById(Long id) {
		Message message = messageRepository.getOne(id);
		return message;
	}

	@Override
	public List<Message> getMessagesByProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessagesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMessage(Message message) {
		
		messageRepository.save(message);
		
	}

}
