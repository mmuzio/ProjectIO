package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Project;
import com.revature.domain.User;
import com.revature.service.ProjectService;
import com.revature.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ProjectService projectService;

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping(path = "/user/project")
	public List<User> getUsersByCurrentProject(@RequestParam Long project_id) {
		
		Project project = projectService.getProjectById(project_id);
		
		return userService.getUsersByProject(project);
		
	}
	
	@GetMapping(path = "/user")
	public User getCurrentUser(@RequestParam String username) {
		
		return userService.getUserByUsername(username);
		
	}
	
	@GetMapping(path = "/alluser")
	public List<User> getAllUsers() {
		
		return userService.getAll();
		
	}

}
