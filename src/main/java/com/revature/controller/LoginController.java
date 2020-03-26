package com.revature.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.domain.Address;
import com.revature.domain.ProfileImage;
import com.revature.domain.User;
import com.revature.service.FileUploadService;
import com.revature.service.UserService;

@RestController
public class LoginController {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private FileUploadService fileUploadService;
	
	@Autowired
	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}
	
	@PostMapping(value = "/login")
    public @ResponseBody User loginUser(            
            @RequestParam(value="username", required=true) String username,
            @RequestParam(value="password", required=true) String password) {
		
			User user = userService.getUserByUsername(username);
			//Optional<User> user = userRepository.findById(username);
			if (user != null) {
				//User newUser = user.get();
				if (user.getPassword().equals(password)) {
					
					return user;
					
				}
				
			}
			
			return null;
                          
    }
	
	@PostMapping(value = "/register")
    public @ResponseBody void createUser(
    		@RequestParam(value="username", required=true) String username,
    		@RequestParam(value="password", required=true) String password,
            @RequestParam(value="firstName", required=true) String firstName,
            @RequestParam(value="lastName", required=true) String lastName,
            @RequestParam(value="dateOfBirth", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
            @RequestParam(value="street", required=true) String street,
            @RequestParam(value="town", required=true) String town,
            @RequestParam(value="county", required=true) String county,
            @RequestParam(value="postcode", required=true) String postcode,
            @RequestParam(value="image", required=true) MultipartFile image) throws IOException {
		
		if (userService.doesUserExist(username)) {
			
			System.out.println("User already exists!");
			
			return;
			
		} else {
			
			ProfileImage profileImage = fileUploadService.saveFileToS3(image);
    		
    		User newUser = new User(username, password, firstName, lastName, dateOfBirth, profileImage, 
					new Address(street, town, county, postcode));
    		
    		userService.registerUser(newUser);
			
		}
        		
            
    }

}
