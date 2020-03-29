package com.revature.domain;

import java.util.ArrayList;
import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="project")
public class Project {
	
	public Project() {
		super();
	}

	public Project(long id, String pname, String description,
		List<Message> messages, List<User> users) {
	
		super();
		this.id = id;
		this.pname = pname;
		this.description = description;
		this.messages = messages;
		this.users = users;
	}
	
	public Project(long id, String pname, String description) {
	
		super();
		this.id = id;
		this.pname = pname;
		this.description = description;
	}
	
	public Project(String pname, String description) {
		
		super();
		this.pname = pname;
		this.description = description;
	}
	
	@JsonCreator
	public Project(@JsonProperty("id") int id, String pname, String description) {
	
		super();
		Long newId = Long.valueOf(id);
	    this.id = newId;
	    this.pname = pname;
		this.description = description;
	}
	
	public Project(String pname, String description, List<Message> messages, 
			List<User> users) {
	
		super();
		this.pname = pname;
		this.description = description;
		this.messages = messages;
		this.users = users;
	}

	@Id
	@Column(name="project_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(length = 20)
	private String pname;
	
	@Column(length = 100)
	private String description;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Message> messages;
    
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
            name = "Project_Users",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
	@JsonIgnore
    private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		
        return users;
        
    }
	
	public void addUser(User user) {
		
		this.users.add(user);
		
	}
	
	public void setUsers(List<User> users) {
		
        this.users = users;
        
    }

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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
