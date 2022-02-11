package com.poker.response;

import java.util.Set;

public class JoinSessionResponse {

	private String title;
	private Set<UserStoriesRespose> userStories;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<UserStoriesRespose> getUserStories() {
		return userStories;
	}
	public void setUserStories(Set<UserStoriesRespose> userStories) {
		this.userStories = userStories;
	}
	
	
}
