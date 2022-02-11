package com.poker.service;

import java.util.List;

import com.poker.entity.UserStoryEntity;
import com.poker.request.UserStoryRequest;
import com.poker.response.UserStoryResponse;

public interface UserStoryService {

	public UserStoryResponse addUserStory(final String sessionId,final UserStoryRequest request);
	
	public UserStoryResponse deleteUserStory(final String sessionId,final String id);

	public List<UserStoryEntity>findAllUserStories();
	
	
}
