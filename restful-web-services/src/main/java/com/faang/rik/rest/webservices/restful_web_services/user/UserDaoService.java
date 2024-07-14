package com.faang.rik.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	// find All
	// Save User
	// Find One

	private UserRepository userRepository;

	public UserDaoService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	

	public void deleteUser(User user) {
			userRepository.delete(user);
	}

	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

}
