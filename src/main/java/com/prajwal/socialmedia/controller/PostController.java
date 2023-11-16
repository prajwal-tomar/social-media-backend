package com.prajwal.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajwal.socialmedia.entity.Post;
import com.prajwal.socialmedia.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping("/create-post/{userId}")
	ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable("userId") Long userId) throws Exception {
	    return new ResponseEntity<>(postService.createPost(post, userId), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("delete/{postId}/user/{userId}")
	// userId will come from spring security as it will be the id of the logged in
	// user.
	ResponseEntity<String> deletePost(@PathVariable("postId") Long postId,@PathVariable("userId") Long userId) throws Exception {
		String postMessageString = postService.deletePost(postId, userId);
		return new ResponseEntity<>(postMessageString, HttpStatus.ACCEPTED);
	}

	@GetMapping("findbyuser/{userId}")
	ResponseEntity<List<Post>> findPostsByUserId(@PathVariable("userId") Long userId) throws Exception {
		List<Post> posts = postService.findPostsByUserId(userId);
		return new ResponseEntity<>(posts, HttpStatus.ACCEPTED);
	}

	@GetMapping("find/{postId}")
	ResponseEntity<Post> findPostByid(@PathVariable("postId") Long postId) {
		Post post = postService.findPostByid(postId);
		return new ResponseEntity<>(post, HttpStatus.ACCEPTED);
	}

	@GetMapping("findall")
	ResponseEntity<List<Post>> findAllPosts() {
		List<Post> posts = postService.findAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.ACCEPTED);
	}

	@PutMapping("/like/{postId}/user/{userId}")
	public ResponseEntity<Post> likedPost(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
		Post likedPost = postService.likedPost(postId, userId);
		return new ResponseEntity<>(likedPost, HttpStatus.ACCEPTED);
	}

	@PutMapping("/save/{postId}/user/{userId}")
	public ResponseEntity<Post> savePost(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
		Post savePost = postService.savedPost(postId, userId);
		return new ResponseEntity<>(savePost, HttpStatus.ACCEPTED);
	}
}
