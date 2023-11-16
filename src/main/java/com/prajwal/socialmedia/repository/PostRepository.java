package com.prajwal.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prajwal.socialmedia.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    // returns all the posts associated with the userId
    @Query("select p from Post p where p.user.userId = :userId")
    List<Post> findPostsByUserId(@Param("userId") Long userId);

}

