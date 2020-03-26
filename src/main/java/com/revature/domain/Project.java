package com.revature.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(long id, String description, List<Message> messages, Set<User> users) {
		super();
		this.id = id;
		this.description = description;
		this.messages = messages;
		this.users = users;
	}
	
	@JsonCreator
	public Project(@JsonProperty("id") int id, String description, List<Message> messages, Set<User> users) {
		super();
		Long newId = Long.valueOf(id);
	    this.id = newId;
		this.description = description;
		this.messages = messages;
		this.users = users;
	}
	
	public Project(String description, List<Message> messages, Set<User> users) {
		super();
		this.description = description;
		this.messages = messages;
		this.users = users;
	}
	
//	@JsonCreator
//	public Project (@JsonProperty("id") int id ) {
//		Long newId = Long.valueOf(id);
//	    this.id = newId;
//	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(length = 100)
	private String description;
	
	@OneToMany(mappedBy = "projectIn", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Message.class)
	@JsonManagedReference(value="project-reference")
	//@JsonIgnore
	private List<Message> messages;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Project_Users",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> users = new HashSet<>();
	
	public Set<User> getUsers() {
		
        return users;
        
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public long getId() {
		return id;
	}
	

	
}
