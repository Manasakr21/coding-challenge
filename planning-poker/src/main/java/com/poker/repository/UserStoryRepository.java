package com.poker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poker.entity.UserStoryEntity;

public interface UserStoryRepository extends JpaRepository<UserStoryEntity, Long>{
	 
	public List<UserStoryEntity> findByIdUserStory(String idUserStory);
	

}
