package com.poker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poker.entity.PokerSessionEntity;

public interface PokerPlanningSessionRespository extends JpaRepository<PokerSessionEntity, String>{

//	Boolean existByTitle(String title);
	Optional<PokerSessionEntity> findBySessionAndIsSessionAliveTrue(String session);
	Optional<PokerSessionEntity> findBySession(String session);
}
