package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="message")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Message {

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Message(long id, String messageBody, User messageSender, Project projectIn) {
		super();
		this.id = id;
		this.messageBody = messageBody;
		this.messageSender = messageSender;
		this.projectIn = projectIn;
	}
	
	@JsonCreator
	public Message(@JsonProperty("id") int id, String messageBody, User messageSender, Project projectIn) {
		super();
		Long newId = Long.valueOf(id);
	    this.id = newId;
		this.messageBody = messageBody;
		this.messageSender = messageSender;
		this.projectIn = projectIn;
	}

	public Message(String messageBody, User messageSender, Project projectIn) {
		super();
		this.messageBody = messageBody;
		this.messageSender = messageSender;
		this.projectIn = projectIn;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(length = 100)
	private String messageBody;
	
	@ManyToOne
	@JoinColumn(name="messageSender")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonBackReference(value="user-reference")
	private User messageSender;
	
	@ManyToOne
	@JoinColumn(name="projectIn")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonBackReference(value="project-reference")
	private Project projectIn;

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public User getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(User messageSender) {
		this.messageSender = messageSender;
	}

	public Project getProjectIn() {
		return projectIn;
	}

	public void setProjectIn(Project projectIn) {
		this.projectIn = projectIn;
	}

	public long getId() {
		return id;
	}
	
}
