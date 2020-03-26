package com.revature.service;

import java.util.List;

import com.revature.domain.Message;
import com.revature.domain.Project;
import com.revature.domain.User;

public interface MessageService {
	
	public Message getMessageById(Long id);
	
	public List<Message> getMessagesByProject(Project project);
	
	public List<Message> getMessagesByUser(User user);

}
