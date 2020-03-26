package com.revature.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "username")
public class User {
	
	@Id
	@Column(name = "name")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(nullable = false, length = 30)
	private String firstName;
	
	@Column(nullable = false, length = 30)
	private String lastName;
	
	@Column(nullable = false)
	private Date dateOfBirth;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private ProfileImage profileImage;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	
	@OneToMany(mappedBy = "messageSender", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Message.class)
	private List<Message> messages = new ArrayList<Message>();
	
	public User(){}
	
	public User(String firstName, String lastName, Date dateOfBirth, ProfileImage profileImage, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
		this.address = address;
	}
	
	public User(String username, String password, String firstName, String lastName, Date dateOfBirth,
			ProfileImage profileImage, Address address) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
		this.address = address;
	}
	
	public User(String username, String password, String firstName, String lastName, Date dateOfBirth,
			ProfileImage profileImage, Address address, List<Message> messages) {
		
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
		this.address = address;
		this.messages = messages;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ProfileImage getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(ProfileImage profileImage) {
		this.profileImage = profileImage;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
