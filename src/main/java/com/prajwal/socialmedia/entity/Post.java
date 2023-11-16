package com.prajwal.socialmedia.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;

@Entity
@Builder
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long postId;
	String caption;
	String image;
	String video;
	
	@JsonIgnore
	@ManyToOne
    User user;
    
    LocalDateTime createdAt;

    @OneToMany
    List<User> liked = new ArrayList<>();

	public Post() {
		super();
	}

	public Post(Long postId, String caption, String image, String video, User user, LocalDateTime createdAt) {
		super();
		this.postId = postId;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createdAt = createdAt;
	}

	public Post(Long postId, String caption, String image, String video, User user, LocalDateTime createdAt,
			List<User> liked) {
		super();
		this.postId = postId;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createdAt = createdAt;
		this.liked = liked;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", caption=" + caption + ", image=" + image + ", video=" + video + ", user="
				+ user + ", createdAt=" + createdAt + ", liked=" + liked + "]";
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<User> getliked() {
		return liked;
	}

	public void setliked(List<User> liked) {
		this.liked = liked;
	}

}
