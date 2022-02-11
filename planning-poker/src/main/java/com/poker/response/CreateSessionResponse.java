package com.poker.response;

public class CreateSessionResponse {

	private String inviteLink;
	
	private String seesionId;

	public String getInviteLink() {
		return inviteLink;
	}

	public void setInviteLink(String inviteLink) {
		this.inviteLink = inviteLink;
	}

	public String getSeesionId() {
		return seesionId;
	}

	public void setSeesionId(String seesionId) {
		this.seesionId = seesionId;
	}

	@Override
	public String toString() {
		return "CreateSessionResponse [inviteLink=" + inviteLink + ", seesionId=" + seesionId + "]";
	}

	
	
}
