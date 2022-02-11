package com.poker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_story")
public class UserStoryEntity {
	
	@Id
	@Column(name = "user_story_id")
	private String idUserStory;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;

	public String getIdUserStory() {
		return idUserStory;
	}

	public void setIdUserStory(String idUserStory) {
		this.idUserStory = idUserStory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserStoryEntity [idUserStory=" + idUserStory + ", description=" + description + ", status=" + status
				+ "]";
	}
	
	


}
