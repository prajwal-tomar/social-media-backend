package com.prajwal.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajwal.socialmedia.entity.User;
import com.prajwal.socialmedia.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	String homePage() {
		return "Welcome to my Ecommerce Store.";
	}
	
	@GetMapping("/search/{id}")
	User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@GetMapping("/search")
	List<User> searchUser(@RequestParam("query") String query) {
		return userService.searchByQuery(query);
	}
	
	@GetMapping("/follow/{userId1}/{userId2}")
	void followUser(@PathVariable Long userId1, @PathVariable Long userId2) {
		userService.followUser(userId1, userId2);
	}
	
	@GetMapping("all")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/register")
	User register(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/search-email")
	List<User> findUserByEmail(@RequestBody String email) {
		return userService.findByEmail(email);
	}
	
}
