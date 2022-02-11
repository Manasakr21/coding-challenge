package com.poker.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="poker_session")
public class PokerSessionEntity {

	@Id
	@Column(name="session")
	private String session;
	
	@Column(name="title")
	private String title;
	
	@Column(name="dock_type")
	private String dockType;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="is_session_alive")
	private Boolean isSessionAlive;
	
	@Column(name="destroyed_at")
	private LocalDateTime destroyed;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="session")
	private Set<UserStoryEntity> userStories;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="session")
	private Set<MemberEntity> members;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="session")
	private Set<VoteEntity> votes;
	

	public Set<VoteEntity> getVotes() {
		return votes;
	}

	public void setVotes(Set<VoteEntity> votes) {
		this.votes = votes;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDockType() {
		return dockType;
	}

	public void setDockType(String dockType) {
		this.dockType = dockType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsSessionAlive() {
		return isSessionAlive;
	}

	public void setIsSessionAlive(Boolean isSessionAlive) {
		this.isSessionAlive = isSessionAlive;
	}

	public LocalDateTime getDestroyed() {
		return destroyed;
	}

	public void setDestroyed(LocalDateTime destroyed) {
		this.destroyed = destroyed;
	}

	public Set<UserStoryEntity> getUserStories() {
		return userStories;
	}

	public void setUserStories(Set<UserStoryEntity> userStories) {
		this.userStories = userStories;
	}

	public Set<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberEntity> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "PokerSessionEntity [session=" + session + ", title=" + title + ", dockType=" + dockType + ", createdAt="
				+ createdAt + ", isSessionAlive=" + isSessionAlive + ", destroyed=" + destroyed + ", userStories="
				+ userStories + ", members=" + members + ", votes=" + votes + "]";
	}


	
	
}
