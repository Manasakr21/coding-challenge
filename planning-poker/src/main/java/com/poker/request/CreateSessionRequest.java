package com.poker.request;

public class CreateSessionRequest {
	
	private String deckType;
	
	private String title;
	
	private String memberName;

	public String getDeckType() {
		return deckType;
	}

	public void setDeckType(String deckType) {
		this.deckType = deckType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "CreateSessionRequest [deckType=" + deckType + ", title=" + title + ", memberName=" + memberName + "]";
	}
	
	
}
