package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Project;
import com.revature.service.ProjectService;

@RestController
public class ProjectController {
	
	private ProjectService projectService;

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping(path = "/project/{id}")
	public Project getProject(@PathVariable Long id) {
		Project project = projectService.getProjectById(id);
		System.out.println(project);
		return project;
	}

	@GetMapping(path = "/project")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
//	@GetMapping(path = "/project/user/{username}")
//	public List<Project> getProjectsByUser(@PathVariable String username) {
//		return projectService.getProjectsByUser(username);
//	}
	
	@PutMapping(path = "/project")
	public void updateProject(@RequestBody Project project) {
		projectService.updateProject(project);
	}
	
	@DeleteMapping(path = "/project/{id}")
	public void deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
	}

	@PostMapping(path = "/project", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> addProject(@RequestBody Project project) {
		projectService.insertProject(project);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

}
