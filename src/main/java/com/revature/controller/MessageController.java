package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Message;
import com.revature.service.MessageService;

@RestController
public class MessageController {
	
	private MessageService messageService;

	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
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
	
//	@GetMapping(path = "/car/user/{username}")
//	public List<Car> getCarsByOwner(@PathVariable String username) {
//		return carService.getCarsByOwner(username);
//	}
	
	@PutMapping(path = "/message")
	public void updateCar(@RequestBody Message message) {
		messageService.updateMessage(message);
	}
	
	@DeleteMapping(path = "/message/{id}")
	public void deleteCar(@PathVariable Long id) {
		messageService.deleteMessage(id);
	}

	@PostMapping(path = "/message", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> addCar(@RequestBody Message message) {
		messageService.insertMessage(message);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

}
