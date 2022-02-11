package com.poker.response;

public class UserStoryResponse {

	private String msg;
	
	private String idUserStory;
	
	private String description;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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

	@Override
	public String toString() {
		return "UserStoryResponse [msg=" + msg + ", idUserStory=" + idUserStory + ", description=" + description + "]";
	}

	
	
}
