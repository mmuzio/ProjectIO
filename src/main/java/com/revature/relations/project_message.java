package com.revature.relations;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table(name="project_message")
public class project_message {
	
	@Id
	long project_id;
	
	@Id
	long message_id;

}
