package com.prajwal.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prajwal.socialmedia.entity.User;
import com.prajwal.socialmedia.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void followUser(Long userId1, Long userId2) {
		User user1 = userRepository.findById(userId1).get();
		User user2 = userRepository.findById(userId2).get();
		System.out.println(userId1 + " is following " + userId2);
		user1.getFollowing().add(userId2);
		System.out.println(user1.getFollowing().size());
		user2.getFollowers().add(userId1);
		System.out.println("Following completed..");
		userRepository.save(user1);
		userRepository.save(user2);
	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmailAddress(email);
	}

	@Override
	public List<User> searchByQuery(String query) {
		return userRepository.searchByQuery(query);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
