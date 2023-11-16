package com.prajwal.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prajwal.socialmedia.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByEmailAddress(String emailAddress);

	@Query("SELECT u FROM User u WHERE u.firstName LIKE %:query% OR u.emailAddress LIKE %:query% OR u.lastName LIKE %:query%")
	public List<User> searchByQuery(@Param("query") String query);

}
