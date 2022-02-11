package com.poker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MemberEntity {

	@Id
	@Column(name="id_member")
	private String idMember;
	
	@Column(name="name")
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
		return "MemberEntity [idMember=" + idMember + ", name=" + name + "]";
	}
	
	
}
