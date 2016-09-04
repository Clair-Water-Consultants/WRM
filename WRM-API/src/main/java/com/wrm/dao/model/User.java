package com.wrm.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "ID")
	String id;

	@Column(name = "NAME")
	String name;
	
	@Column(name = "PASS")
	String pass;
	
	@Column(name = "GROUP_ID")
	String groupId;
	
	@Column(name = "FIRST_NAME")
	String firstName;
	
	@Column(name = "LAST_NAME")
	String lastName;
	
	@Column(name = "EMAIL_ID")
	String emailId;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	Date createdTime;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TIME")
	Date updatedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", groupId=" + groupId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + "]";
	}
	
	
}
