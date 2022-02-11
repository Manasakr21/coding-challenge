package com.poker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.poker.entity.PokerSessionEntity;
import com.poker.entity.UserStoryEntity;
import com.poker.exception.NotFoundException;
import com.poker.repository.PokerPlanningSessionRespository;
import com.poker.repository.UserStoryRepository;
import com.poker.request.UserStoryRequest;
import com.poker.response.UserStoryResponse;

@Service
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	private PokerPlanningSessionRespository pokerPlanningSessionRespository;

	@Autowired
	private UserStoryRepository userStoryRepository;

	@Override
	public UserStoryResponse addUserStory(final String sessionId, final UserStoryRequest request) {
		Optional<PokerSessionEntity> optionalPoker = pokerPlanningSessionRespository.findBySession(sessionId);
		if (optionalPoker.isPresent()) {
			PokerSessionEntity entity = optionalPoker.get();
			UserStoryEntity userStoryEntity = converUserStoriesModelToEntity(request);
			if (!CollectionUtils.isEmpty(entity.getUserStories())) {
				entity.getUserStories().add(userStoryEntity);
			} else {
				Set<UserStoryEntity> userEntities = new HashSet<>();
				userEntities.add(userStoryEntity);
				entity.setUserStories(userEntities);
			}
			pokerPlanningSessionRespository.save(entity);

			UserStoryResponse response = new UserStoryResponse();
			response.setIdUserStory(userStoryEntity.getIdUserStory());
			response.setDescription(userStoryEntity.getDescription());
			response.setMsg("user story added successfully");
			return response;
		}else{
			throw new NotFoundException(String.format("Invalid Session '%s'", sessionId));
		}

	}

	private UserStoryEntity converUserStoriesModelToEntity(UserStoryRequest request) {
		UserStoryEntity entity = new UserStoryEntity();
		entity.setDescription(request.getDescription());
		entity.setIdUserStory(request.getIdUserStory());
		entity.setStatus(request.getStatus() != null ? request.getStatus() : "PENDING");
		return entity;
	}

	@Override
	public UserStoryResponse deleteUserStory(final String sessionId, final String id) {
		Optional<PokerSessionEntity> optionalPoker = pokerPlanningSessionRespository.findBySession(sessionId);
		if (optionalPoker.isPresent()) {
			List<UserStoryEntity> data = userStoryRepository.findByIdUserStory(id);
			if (!CollectionUtils.isEmpty(data)) {
				UserStoryEntity userStroy = data.get(0);
				if (userStroy.getStatus().contentEquals("PENDING")) {
					userStoryRepository.delete(userStroy);
				}
				return generateResponse(userStroy);
			} else {
				throw new NotFoundException(String.format("UserStory Not found with this id '%s'", id));
			}
		} else {
			throw new NotFoundException(String.format("Invalid Session '%s'", sessionId));
		}

	}

	private UserStoryResponse generateResponse(UserStoryEntity userStroy) {
		UserStoryResponse response = new UserStoryResponse();
		response.setMsg("Deleted userStory succssfully");
		response.setIdUserStory(userStroy.getIdUserStory());
		return null;
	}

//	@Override
//	public UserStoryEntity addUserStory(UserStoryRequest request) {
//		
//		UserStoryEntity entity = userStoryRepository.save(generateModelToObject(request));
//		return entity;
//	}
//
//	private UserStoryEntity generateModelToObject(UserStoryRequest request) {
//		UserStoryEntity entity=new UserStoryEntity();
//		entity.setIdUserStory(request.getIdUserStory());
//		entity.setDescription(request.getDescription());
//		entity.setStatus(request.getStatus()!=null ? request.getStatus(): "PENDING");
//		return entity;
//	}
//
//	@Override
//	public UserStoryEntity deleteUserStory(String id) {
//		List<UserStoryEntity> data = userStoryRepository.findByIdUserStory(id);
//		if(!data.isEmpty()) {
//			UserStoryEntity entity	=data.get(0);
//			if(entity.getStatus().contentEquals("PENDING")) {
//				userStoryRepository.delete(entity);
//				return entity;
//			}
//			
//		}
//		return null;
//	}
//
	@Override
	public List<UserStoryEntity> findAllUserStories() {
		List<UserStoryEntity> userStories = userStoryRepository.findAll();
		if (CollectionUtils.isEmpty(userStories)) {
			throw new NotFoundException("No user Stories found");
		} else {
			return userStories;
		}
	}

}
