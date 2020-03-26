package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.domain.Project;
import com.revature.domain.User;
import com.revature.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;
	
	//private UserRepository userRepository;
	
	@Autowired
	public void setProjectRepository(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
	@Override
	public Project getProjectById(Long id) {
		return projectRepository.getOne(id);
	}

	@Override
	public List<Project> getProjectsByUser(User user) {
		return null;
	}

}
