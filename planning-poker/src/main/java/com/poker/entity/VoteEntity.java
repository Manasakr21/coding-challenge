package com.poker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vote")
public class VoteEntity {

	@Id
	@Column(name = "id_member")
	private String idMember;
	
	@Column(name = "id_user_story")
	private String idUserStory;
	
	@Column(name = "status")
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
		return "VoteEntity [idMember=" + idMember + ", idUserStory=" + idUserStory + ", status=" + status + "]";
	}

	
	
}
