package com.revature.service;

import java.util.List;

import com.revature.domain.Project;
import com.revature.domain.User;

public interface ProjectService {
	
	public Project getProjectById(Long id);
	
	public List<Project> getProjectsByUser(User user);

}
