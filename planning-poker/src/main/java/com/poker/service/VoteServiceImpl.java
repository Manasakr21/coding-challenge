package com.poker.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.poker.entity.PokerSessionEntity;
import com.poker.entity.VoteEntity;
import com.poker.repository.PokerPlanningSessionRespository;
import com.poker.request.VoteRequest;
import com.poker.response.VoteResponse;

@Service
public class VoteServiceImpl implements VoteService{

	@Autowired
	private PokerPlanningSessionRespository pokerPlanningSessionRespository;
	
	@Override
	public VoteResponse vote(VoteRequest request, String sessionId) {
		Optional<PokerSessionEntity> optionalPoker = pokerPlanningSessionRespository.findBySession(sessionId);
		if(optionalPoker.isPresent()) {
			PokerSessionEntity entity=optionalPoker.get();
			VoteEntity vote=convertVoteModelToEntity(request);
			if(!CollectionUtils.isEmpty(entity.getVotes())) {
				entity.getVotes().add(vote);
			}else {
				Set<VoteEntity> voteEntities=new HashSet<>();
				voteEntities.add(vote);
				entity.setVotes(voteEntities);
			}
			pokerPlanningSessionRespository.save(entity);
			
			return convertVoteEntityToModel(vote);
		}
		return null;
			
	}

	private VoteEntity convertVoteModelToEntity(VoteRequest request) {
		
		VoteEntity entity=new VoteEntity();
		entity.setIdMember(request.getIdMember());
		entity.setIdUserStory(request.getIdUserStory());
		entity.setStatus("VOTED");
		return entity;
	}
	
	private VoteResponse convertVoteEntityToModel(VoteEntity entity) {
		
		VoteResponse response=new VoteResponse();
		response.setIdMember(entity.getIdMember());
		response.setMsg("Voted succesfully");
		return response;
	}

}
