package com.prajwal.socialmedia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prajwal.socialmedia.entity.Post;
import com.prajwal.socialmedia.entity.User;
import com.prajwal.socialmedia.repository.PostRepository;
import com.prajwal.socialmedia.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Override
	public Post createPost(Post post, Long userId) throws Exception {
		Optional<User> existingUser = userRepository.findById(userId);

		if (existingUser.isEmpty()) {
			throw new Exception("User with ID " + userId + " not found");
		}

		Post savedPost = new Post(post.getPostId(), post.getCaption(), post.getImage(), post.getVideo(),
				existingUser.get(), LocalDateTime.now());

		return postRepository.save(savedPost);
	}

	@Override
	public String deletePost(Long postId, Long userId) throws Exception {
		Post existingPost = findPostByid(postId);
		Optional<User> existingUser = userRepository.findById(userId);

		if (existingUser.isEmpty())
			throw new Exception("User doesn't exist");

		if (existingPost.getUser().getUserId() != userId) {
			throw new Exception("You cannot delete someone else's post.");
		}

		postRepository.delete(existingPost);
		return "Post successfully deleted.";
	}

	@Override
	public List<Post> findPostsByUserId(Long userId) throws Exception {
		return postRepository.findPostsByUserId(userId);
	}

	@Override
	public Post findPostByid(Long postId) {
		return postRepository.findById(postId).get();
	}

	@Override
	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post savedPost(Long postId, Long userId) {
		Post existingPost = findPostByid(postId);
		User existingUser = userRepository.findById(userId).get();

		if (existingUser.getSaved().contains(existingPost)) {
			existingUser.getSaved().remove(existingPost);
		} else {
			existingUser.getSaved().add(existingPost);
		}
		userRepository.save(existingUser);
		return existingPost;
	}

	@Override
	public Post likedPost(Long postId, Long userId) {
		Post existingPost = findPostByid(postId);
		User existingUser = userRepository.findById(userId).get();

		// if already liked, then remove the user from the list which is equivalent to
		// disliking the post
		if (existingPost.getliked().contains(existingUser)) {
			existingPost.getliked().remove(existingUser);
			return postRepository.save(existingPost);
		}
		// like the post
		existingPost.getliked().add(existingUser);
		return postRepository.save(existingPost);
	}

}
