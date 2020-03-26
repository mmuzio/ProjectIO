package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.domain.Project;
import com.revature.domain.User;
import com.revature.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getOne(username);
	}

	@Override
	public void registerUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getUsersByProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

}
