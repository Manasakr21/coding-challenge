package com.poker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poker.entity.PokerSessionEntity;
import com.poker.exceptionhandler.GlobalExceptionHandler;
import com.poker.request.CreateSessionRequest;
import com.poker.request.JoinSessionRequest;
import com.poker.response.CreateSessionResponse;
import com.poker.response.GenericResponse;
import com.poker.response.JoinSessionResponse;
import com.poker.service.SessionServiceImpl;

@RestController
@RequestMapping("/session")
public class SessionMgmtController extends GlobalExceptionHandler{
	
	
	@Autowired
	private SessionServiceImpl sessionService;
	
	@PostMapping
	public ResponseEntity<CreateSessionResponse> createSession(@RequestBody CreateSessionRequest request) {
		CreateSessionResponse response=new CreateSessionResponse();
		try {
			String session = sessionService.createSession(request);
			final String invitation=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{sessionid}")
					.replaceQueryParam("sessionid")
					.buildAndExpand(session)
					.toUriString();
			
			response.setInviteLink(invitation);
			response.setSeesionId(session);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Exception occured: "+e);
			throw e;
		}
		
	}
	
	@PostMapping("/{sessionId}")
	public ResponseEntity<JoinSessionResponse> joinSession(@PathVariable String sessionId,@RequestBody JoinSessionRequest request) {
		JoinSessionResponse response = new JoinSessionResponse();
		try {
			 response = sessionService.joinSession(request, sessionId);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Exception occured: "+e);
			throw e;
		}
	}
	
	@GetMapping("/{sessionId}")
	public ResponseEntity<PokerSessionEntity> findDetailsBySessionId(@PathVariable final String sessionId){
		PokerSessionEntity response=null;
		try {
			response=sessionService.findDetailsBySessionId(sessionId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			throw e;
		}
	}
	
	@DeleteMapping("/{sessionId}")
	public ResponseEntity<GenericResponse> deleteBySessionId(@PathVariable final String sessionId){
		try {
			GenericResponse response=sessionService.deleteBySessionId(sessionId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			throw e;
		}
	}
	

}
