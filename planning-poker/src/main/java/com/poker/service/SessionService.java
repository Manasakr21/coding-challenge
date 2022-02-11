package com.poker.service;

import com.poker.entity.PokerSessionEntity;
import com.poker.request.CreateSessionRequest;
import com.poker.request.JoinSessionRequest;
import com.poker.response.GenericResponse;
import com.poker.response.JoinSessionResponse;

public interface SessionService {

	
	public String createSession(final CreateSessionRequest request);
	
	public JoinSessionResponse joinSession(final JoinSessionRequest request,final String sessionId);
	
	public PokerSessionEntity findDetailsBySessionId(final String sessionId);
	
	public GenericResponse deleteBySessionId(final String sessionId);
}
