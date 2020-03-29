package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Project;
import com.revature.domain.User;
import com.revature.service.ProjectService;
import com.revature.service.UserService;

@CrossOrigin("*")
@RestController
public class ProjectController {
	
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
	
	@GetMapping(path = "/project/{id}")
	public Project getProject(@PathVariable Long id,
			HttpServletRequest request) {
		
		HttpSession sess = request.getSession(false);
		
		Project project = projectService.getProjectById(id);
		
		sess.setAttribute("project", project);
		
		System.out.println(project);
		
		return project;
	}

	@GetMapping(path = "/project")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping(path = "/project/user")
	public List<Project> getProjectsByCurrentUser(@RequestParam String username) {
		
//		HttpSession sess = request.getSession(false);
//		
//		User user = (User) sess.getAttribute("user"); 
		
		//String username = user.getUsername();
		
		return projectService.getProjectsByUser(username);
		
	}
	
	@PostMapping(path = "/project/user")
	public void addUserToProjectByIdAndUsername(@RequestParam Long id, @RequestParam String username) {
		
		Project project = projectService.getProjectById(id);
		
		User user = userService.getUserByUsername(username);
		
		project.addUser(user);
		
		projectService.updateProject(project);
		
	}
	
	@PutMapping(path = "/project")
	public void updateProject(@RequestBody Project project) {
		projectService.updateProject(project);
	}
	
	@DeleteMapping(path = "/project/{id}")
	public void deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
	}

	//@PostMapping(path = "/project")
			//, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			//MediaType.APPLICATION_JSON_VALUE })
	@PostMapping(path = "/project")
	public @ResponseBody Project addProject(@RequestBody Project project,
			HttpServletRequest request) {
		
		Project newProject = projectService.insertProject(project);
		
//		System.out.println("Project is ...");
//		
//		System.out.println(project.getPname());
//		
//		System.out.println(project.getDescription());
//		
//		HttpSession sess = request.getSession(false);
//		
//		User user = (User) sess.getAttribute("user");
//		
//		System.out.println("user is ...");
//		
//		System.out.println(user.getUsername());
//		
//		System.out.println(user.getEmail());
//		
//		System.out.println(user.getFirstName());
//		
//		System.out.println(user.getLastName());
//		
//		System.out.println(user.getPassword());
//		
//		System.out.println(user.getDateOfBirth());
//		
//		newProject.addUser(user);
//		
//		projectService.updateProject(newProject);
//		
//		//sess.setAttribute("project", project);
		
		return newProject;
		
		//return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		
	}

}
