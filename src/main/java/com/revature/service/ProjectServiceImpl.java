package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.domain.Project;
import com.revature.repository.ProjectRepository;
import com.revature.repository.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;
	
	private UserRepository userRepository;
	
	@Autowired
	public void setProjectRepository(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Project getProjectById(Long id) {
		
		return projectRepository.getOne(id);
		
	}

	@Override
	public List<Project> getProjectsByUser(String username) {
		
		return userRepository.getOne(username).getProjects();
		
	}

	@Override
	public List<Project> getAllProjects() {
		
		return projectRepository.findAll();
		
	}

	@Override
	public void updateProject(Project project) {
		
		projectRepository.save(project);
		
	}

	@Override
	public void deleteProject(Long id) {
		
		projectRepository.deleteById(id);
		
	}

	@Override
	public Project insertProject(Project project) {
		
		Project newProject = projectRepository.saveAndFlush(project);
		
		return newProject;
		
		//projectRepository.save(project);
		
	}

}
