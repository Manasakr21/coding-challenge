package com.poker.controller;

import java.util.List;

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

import com.poker.entity.UserStoryEntity;
import com.poker.exceptionhandler.GlobalExceptionHandler;
import com.poker.request.UserStoryRequest;
import com.poker.response.UserStoryResponse;
import com.poker.service.UserStoryService;

@RestController
@RequestMapping("/userstories")
public class UserStoryController extends GlobalExceptionHandler{

	@Autowired
	private UserStoryService userStoryService;
	
	
	@PostMapping("/{sessionId}")
	public ResponseEntity<UserStoryResponse> addUserStory(@PathVariable String sessionId, @RequestBody final UserStoryRequest request){
		UserStoryResponse response=null;
		try {
			response = userStoryService.addUserStory(sessionId,request);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Exception:"+e);
			throw e;
		}
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserStoryEntity>> getAllUserStory(){
		List<UserStoryEntity> response=null;
		try {
			response = userStoryService.findAllUserStories();
			return new ResponseEntity<List<UserStoryEntity>>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception occured: "+e);
			throw e;
		}
		
		
	}
	
	@DeleteMapping("/{sessionId}/{id}")
	public ResponseEntity<UserStoryResponse> deleteUserStory(@PathVariable final String sessionId,@PathVariable final String id){
		try {
			UserStoryResponse response=userStoryService.deleteUserStory(sessionId,id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception occured: "+e);
			throw e;
		}
	}

}
