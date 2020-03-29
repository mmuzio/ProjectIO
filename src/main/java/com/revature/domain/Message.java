package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	public Message(long id, String messageBody,
			User messageSender, Project project) {
	
		super();
		this.id = id;
		this.messageBody = messageBody;
		this.messageSender = messageSender;
		this.project = project;
	}
	
	@JsonCreator
	public Message(@JsonProperty("id") int id, String messageBody,
		 User messageSender, Project project) {
	
		super();
		Long newId = Long.valueOf(id);
	    this.id = newId;
		this.messageBody = messageBody;
		this.messageSender = messageSender;
		this.project = project;
	}

	public Message(String messageBody, Project project, 
			User messageSender, Project projectIn) {
		super();
		this.messageBody = messageBody;
		this.messageSender = messageSender;
		this.project = project;
	}

	@Id
	@Column(name="message_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(name = "message_text", length = 100)
	private String messageBody;
	
//	@ManyToOne
//	@JoinColumn(name="messageSender")
//	@JsonIdentityReference(alwaysAsId = true)
//	@JsonBackReference(value="user-reference")
//	private User messageSender;
//	
//	@ManyToOne
//	@JoinColumn(name="projectIn")
//	@JsonIdentityReference(alwaysAsId = true)
//	@JsonBackReference(value="project-reference")
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User messageSender;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getId() {
		return id;
	}
	
}
