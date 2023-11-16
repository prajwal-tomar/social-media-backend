package com.prajwal.socialmedia.service;

import java.util.List;

import com.prajwal.socialmedia.entity.User;

public interface UserService {

	User createUser(User user);

	User findUserById(Long id);

	void followUser(Long userId1, Long userId2);

	List<User> findByEmail(String email);

	List<User> searchByQuery(String query);

	List<User> getAllUsers();

}
