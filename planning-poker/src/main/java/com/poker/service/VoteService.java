package com.poker.service;

import com.poker.request.VoteRequest;
import com.poker.response.VoteResponse;

public interface VoteService {

	public VoteResponse vote(final VoteRequest request,final String sessionId);
}
