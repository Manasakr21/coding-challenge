package com.poker.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.poker.entity.MemberEntity;
import com.poker.entity.PokerSessionEntity;
import com.poker.entity.UserStoryEntity;
import com.poker.exception.NotFoundException;
import com.poker.repository.PokerPlanningSessionRespository;
import com.poker.request.CreateSessionRequest;
import com.poker.request.JoinSessionRequest;
import com.poker.response.GenericResponse;
import com.poker.response.JoinSessionResponse;
import com.poker.response.UserStoriesRespose;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private PokerPlanningSessionRespository sessionRespository;
	
	
	@Override
	public String createSession(final CreateSessionRequest request) {
	  
		PokerSessionEntity sessionEntity=new PokerSessionEntity();
		
		sessionEntity.setSession(generateRandomUUID());
		sessionEntity.setTitle(request.getTitle());
		sessionEntity.setDockType(request.getDeckType());
		sessionEntity.setCreatedAt(LocalDateTime.now());
		sessionEntity.setIsSessionAlive(true);
		sessionRespository.save(sessionEntity);
		
		return sessionEntity.getSession();
		
	}
	
	
	
    private String generateRandomUUID() {
        final UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }



	@Override
	public JoinSessionResponse joinSession(final JoinSessionRequest request, String sessionId) {
		JoinSessionResponse response=new JoinSessionResponse();
		try {
			Optional<PokerSessionEntity> optionalPoker= sessionRespository.findBySessionAndIsSessionAliveTrue(sessionId);
			if(optionalPoker.isPresent()) {
				PokerSessionEntity  entity=optionalPoker.get();
				
				MemberEntity member=new MemberEntity();
				member.setIdMember(request.getIdMember());
				member.setName(request.getName());
				
				if(!CollectionUtils.isEmpty(entity.getMembers())) {
					entity.getMembers().add(member);
				}else {
					Set<MemberEntity> memberEntities=new HashSet<>();
					memberEntities.add(member);
					entity.setMembers(memberEntities);
				}
				
				sessionRespository.save(entity);
				
				response.setTitle(entity.getTitle());
				Set<UserStoryEntity> userStories = entity.getUserStories();
				response.setUserStories(convertUserStoryEntityToModel(userStories));
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception:"+e);
		}
		
		return response;
		
	}
	



	public Set<UserStoriesRespose> convertUserStoryEntityToModel(final Set<UserStoryEntity> userStories){
		Set<UserStoriesRespose> response=new HashSet<>();
		for(UserStoryEntity user:userStories) {
			UserStoriesRespose userStory=new UserStoriesRespose();
			userStory.setIdUserStory(user.getIdUserStory());
			userStory.setDescription(user.getDescription());
			userStory.setStatus(user.getStatus());
			response.add(userStory);
		}
		return response;
	}


	@Override
	public PokerSessionEntity findDetailsBySessionId(String sessionId) {
		Optional<PokerSessionEntity> optionalEntity = sessionRespository.findBySession(sessionId);
		if(optionalEntity.isPresent()) {
			return optionalEntity.get();
		}
		
		throw new NotFoundException(String.format("No Data found with this id '%s'", sessionId));
	}



	@Override
	public GenericResponse deleteBySessionId(String sessionId) {
		Optional<PokerSessionEntity> optionalEntity = sessionRespository.findBySession(sessionId);
		if(optionalEntity.isPresent()) {
			PokerSessionEntity entity=optionalEntity.get();
			sessionRespository.delete(entity);
			
			GenericResponse response =new GenericResponse();
			response.setMsg("Session destroyed Succesfully");
			return response;
		}
		
		throw new NotFoundException(String.format("No Data found with this id '%s'", sessionId));
	}
	
	

}
