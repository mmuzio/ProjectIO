package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.DisplayMessage;
import com.revature.domain.Message;
import com.revature.domain.Project;
import com.revature.domain.User;
import com.revature.service.MessageService;
import com.revature.service.ProjectService;
import com.revature.service.UserService;

@CrossOrigin("*")
@RestController
public class MessageController {
	
	private MessageService messageService;

	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	private ProjectService projectService;

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path = "/message/{id}")
	public Message getMessage(@PathVariable Long id) {
		Message message = messageService.getMessageById(id);
		System.out.println(message);
		return message;
	}

	@GetMapping(path = "/message")
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	
//	@GetMapping(path = "/message/user/{username}")
//	public List<Message> getMessagesByMessageSender(@PathVariable String username) {
//		return messageService.getMessagesByUsername(username);
//	}
//	
	@GetMapping(path = "/message/project/{id}")
	public List<Message> getMessagesByProject(@PathVariable Long id) {
		return messageService.getMessagesByProject(id);
	}
	
	@GetMapping(path = "/message/project")
	public List<DisplayMessage> getMessagesByCurrentProject(@RequestParam Long project_id) {		
		
		List<Message> messageList = messageService.getMessagesByProject(project_id);
		List<DisplayMessage> displayMessageList = new ArrayList<DisplayMessage>();
		for (int i = 0; i < messageList.size(); i++) {
			Message message = messageList.get(i);
			String messageBody = message.getMessageBody();
			User messageSender = message.getMessageSender();
			String username = messageSender.getUsername();
			DisplayMessage displayMessage = new DisplayMessage(messageBody, username);
			displayMessageList.add(displayMessage);
			
		}
		return displayMessageList;
		
	}
	
	@PutMapping(path = "/message")
	public void updateMessage(@RequestBody Message message) {
		messageService.updateMessage(message);
	}
	
	@DeleteMapping(path = "/message/{id}")
	public void deleteMessage(@PathVariable Long id) {
		messageService.deleteMessage(id);
	}

	@PostMapping(path = "/message")
	public ResponseEntity<HttpStatus> addMessage(@RequestParam Long message_id,
			@RequestParam String messageBody,
			@RequestParam Long project_id,
			@RequestParam String username) {
		
		User messageSender = userService.getUserByUsername(username);
		
		Project project = projectService.getProjectById(project_id);
		
		Message message = new Message(message_id, messageBody, messageSender, project);
		
		// User messageSender = (User) sess.getAttribute("user");
		
		// Project project = (Project) sess.getAttribute("project");
		
		// message.setMessageSender(messageSender);
		
		// message.setProject(project);
		
		messageService.insertMessage(message);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
//	@PostMapping(path = "/project/user")
//	public void addUserAndProjectToMessageByIdAndUsername(@RequestParam Long message_id, @RequestParam Long project_id, @RequestParam String username) {
//		
//		Project project = projectService.getProjectById(project_id);
//		
//		User user = userService.getUserByUsername(username);
//		
//		Message message = messageService.getMessageById(message_id);
//		
//		message.addUser(user);
//		
//		projectService.updateProject(project);
//		
//	}

}
