package com.prajwal.socialmedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prajwal.socialmedia.entity.Post;

@Service
public interface PostService {
	// throws exception in case userId doesn't exist.
	Post createPost(Post post, Long userId) throws Exception;
	
	String deletePost(Long postId, Long userId) throws Exception;
	
	List<Post> findPostsByUserId(Long userId) throws Exception;
	
	Post findPostByid(Long postId);
	
	List<Post> findAllPosts();
	
	Post savedPost(Long postId, Long userId);
	
	Post likedPost(Long postId, Long userId);

}
