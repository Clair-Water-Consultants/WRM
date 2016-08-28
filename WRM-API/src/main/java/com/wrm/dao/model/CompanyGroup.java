package com.wrm.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "COMPANY_GROUP")
public class CompanyGroup {
	@Id
	@Column(name = "ID")
	String id;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "DESCRIPTION")
	String description;
	
	@Column(name = "ADDRESS")
	String address;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "CompanyGroup [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

}
