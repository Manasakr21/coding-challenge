package com.poker.request;

public class UserStoryRequest {

	private String idUserStory;
	
	private String description;
	
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
		return "UserStoryRequest [idUserStory=" + idUserStory + ", description=" + description + ", status=" + status
				+ "]";
	}

	

	
}
