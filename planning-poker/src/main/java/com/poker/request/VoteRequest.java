package com.poker.request;

public class VoteRequest {

	private String idMember;
	
	private String idUserStory;
	
	private String status;

	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	public String getIdUserStory() {
		return idUserStory;
	}

	public void setIdUserStory(String idUserStory) {
		this.idUserStory = idUserStory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VoteRequest [idMember=" + idMember + ", idUserStory=" + idUserStory + ", status=" + status + "]";
	}

	
	
}
