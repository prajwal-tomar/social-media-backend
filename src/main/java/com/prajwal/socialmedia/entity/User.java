package com.prajwal.socialmedia.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long userId;
	String emailAddress;
	String firstName;
	String lastName;
	String password;
	List<Long> followers = new ArrayList<>();
	List<Long> following = new ArrayList<>();

    @ManyToMany
    List<Post> saved = new ArrayList<>();

	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Long> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Long> followers) {
		this.followers = followers;
	}

	public List<Long> getFollowing() {
		return following;
	}

	public void setFollowing(List<Long> following) {
		this.following = following;
	}

	public List<Post> getSaved() {
		return saved;
	}

	public void setSaved(List<Post> saved) {
		this.saved = saved;
	}

	public User(Long userId, String emailAddress, String firstName, String lastName, String password,
			List<Long> followers, List<Long> following, List<Post> saved) {
		super();
		this.userId = userId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.followers = followers;
		this.following = following;
		this.saved = saved;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", followers=" + followers + ", following=" + following
				+ ", saved=" + saved + "]";
	}

}
