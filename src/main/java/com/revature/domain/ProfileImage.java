package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile_image")
public class ProfileImage {

	public ProfileImage(){}
	
	public ProfileImage(String key, String url) {
		this.key = key;
		this.url =url;		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getId() {
		return id;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column(name = "s3_key", nullable = false, length=200)
	private String key;
	
	@Column(name = "url", nullable = false, length=1000)
	private String url;
	
}
