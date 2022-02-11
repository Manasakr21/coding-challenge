package com.poker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poker.exceptionhandler.GlobalExceptionHandler;
import com.poker.request.VoteRequest;
import com.poker.response.VoteResponse;
import com.poker.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteMgmtController extends GlobalExceptionHandler{
	
	@Autowired
	private VoteService voteService;
	
	@PostMapping("/{sessionId}")
	public ResponseEntity<VoteResponse> vote(@PathVariable final String sessionId,@RequestBody VoteRequest request) {
		VoteResponse response=null;
		try {
			response = voteService.vote(request, sessionId);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println("Exception:"+e);
			throw e;
		}
		
	}

}
