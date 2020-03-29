package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.domain.Message;
import com.revature.repository.MessageRepository;
import com.revature.repository.ProjectRepository;
import com.revature.repository.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	private ProjectRepository projectRepository;
	
	@Autowired
	public void setProjectRepository(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	private MessageRepository messageRepository;
	
	@Autowired
	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public Message getMessageById(Long id) {
		
		return messageRepository.getOne(id);
		
	}

	@Override
	public List<Message> getMessagesByProject(Long id) {
		return projectRepository.getOne(id).getMessages();
	}

	@Override
	public List<Message> getMessagesByUsername(String username) {
		return userRepository.getOne(username).getMessages();
	}

	@Override
	public void insertMessage(Message message) {
		
		messageRepository.save(message);
		
	}

	@Override
	public void deleteMessage(Long id) {
		
		messageRepository.deleteById(id);
		
	}

	@Override
	public void updateMessage(Message message) {
		
		messageRepository.save(message);
		
	}

	@Override
	public List<Message> getAllMessages() {
		
		return messageRepository.findAll();
		
	}

}
