package com.faang.rik.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faang.rik.rest.webservices.restful_web_services.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}

	// Get /users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.getAllUsers();
	}

	// Get /users{id}
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable Long id) {
		User user = service.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+id);
		}
		return user;
	}

	// Post /users
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.createUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location ).build();
	}


	// Delete /users{id}
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		User user = service.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+id);
		}
		service.deleteUser(user);
	}
}
