package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/users/add")
	public User addUser(@RequestBody(required = false) User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users/getParticularUser/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@GetMapping("/users/getAParticularUser/details")
	public Optional<User> getUserDetails(@RequestBody(required = false) User user) {
		return userRepository.getUserDetails(user.getId(), user.getFirstName(), user.getLastName(),
											user.getUsername(), user.getEmail());
	}
	
	@GetMapping("/users/all")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
