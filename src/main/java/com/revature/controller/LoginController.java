package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Auth;
import com.revature.domain.User;
import com.revature.service.UserService;

@CrossOrigin("*")
@RestController
public class LoginController {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
//	private FileUploadService fileUploadService;
//	
//	@Autowired
//	public void setFileUploadService(FileUploadService fileUploadService) {
//		this.fileUploadService = fileUploadService;
//	}
	
	@PostMapping(value = "/login")
    public @ResponseBody User loginUser(@RequestBody Auth auth, HttpServletRequest request) 
	{          
//            @RequestParam(value="username", required=true) String username,
//            @RequestParam(value="password", required=true) String password
    	
    		String username = auth.getUsername();
    		
    		String password = auth.getPassword();
		
			User user = userService.getUserByUsername(username);
			
			System.out.println("user is ...");
			
			System.out.println(user.getUsername());
			
			System.out.println(user.getPassword());
			
			System.out.println(user.getFirstName());
			
			if (user != null) {
				
				if (user.getPassword().equals(password)) {
					
					HttpSession sess = request.getSession(true);
					
					sess.setAttribute("user", user);
					
					return user;
					
				}
				
			}
			
			return null;
                          
    }
	
	@PostMapping(value = "/register")
    public @ResponseBody void createUser(@RequestBody User user)
//    		@RequestParam(value="username", required=true) String username,
//    		@RequestParam(value="password", required=true) String password,
//            @RequestParam(value="firstName", required=true) String firstName,
//            @RequestParam(value="lastName", required=true) String lastName,
//            @RequestParam(value="dateOfBirth", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
//            @RequestParam(value="email", required=true) String email
//             @RequestParam(value="image", required=true) MultipartFile image
    		
             throws IOException {
		
		String username = user.getUsername();
		
		System.out.println(username);
		
//		System.out.println(password);
//		
//		System.out.println(firstName);
//		
//		System.out.println(lastName);
//		
//		System.out.println(dateOfBirth);
		
		if (userService.doesUserExist(username)) {
			
			System.out.println("User already exists!");
			
			return;
			
		} else {
			
			//ProfileImage profileImage = fileUploadService.saveFileToS3(image);
    		
//    		User newUser = new User(username, password, firstName, lastName,
//    				dateOfBirth, email);
    		
    		userService.registerUser(user);
			
		}
        		
            
    }

}
