package com.revature.service;

import java.util.List;

import com.revature.domain.Project;

public interface ProjectService {
	
	public Project getProjectById(Long id);
	
	public List<Project> getProjectsByUser(String username);

	public List<Project> getAllProjects();

	public void updateProject(Project project);

	public void deleteProject(Long id);

	public Project insertProject(Project project);

}
