package com.wrm.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ct")
public class Bay {
	
	@Id
	@Column(name = "ID")
	String id;

	@Column(name = "NAME")
	String name;
	
	@Column(name = "GROUP_ID")
	String groupId;
	
	@Column(name = "USER_ID")
	String userId;

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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
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
		return "Bay [id=" + id + ", name=" + name + ", groupId=" + groupId + ", userId=" + userId
				+ ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + "]";
	}
}
