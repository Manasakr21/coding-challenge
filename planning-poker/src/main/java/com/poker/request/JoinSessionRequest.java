package com.poker.request;

public class JoinSessionRequest {
	
	private String idMember;
	private String name;
	public String getIdMember() {
		return idMember;
	}
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "JoinSessionRequest [idMember=" + idMember + ", name=" + name + "]";
	}
	
	

}
