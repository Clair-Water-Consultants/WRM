package com.wrm.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "clair_data")
public class WrmData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	@Column(name = "user_id")
	private String userId = null;

	@Column(name = "CT_id")
	private String ctId = null;
	
	@Column(name = "group_id")
	private String groupId = null;

	@Column(name = "water_id")
	private String waterId = null;

	@Column(name = "element_id")
	private String elementId = null;
	
	@Column(name = "element_value")
	private double elementValue = 0;

	@Column(name = "criteria")
	private String criteria = null;
	
	@Column(name = "created_time")
	//@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date timeCreated = new Date();
	
	@Column(name = "updated_time")
	//@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date timeUpdated = new Date();
	
	/*@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date newTimeUpdated = new Date();
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date newTimeCreated = new Date();*/
	
	@Column(name = "bay_id")
	private String bay_id = null;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getElementValue() {
		return elementValue;
	}

	public void setElementValue(double elementValue) {
		this.elementValue = elementValue;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCtId() {
		return ctId;
	}

	public void setCtId(String ctId) {
		this.ctId = ctId;
	}

	public String getWaterId() {
		return waterId;
	}

	public void setWaterId(String waterId) {
		this.waterId = waterId;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getBayId() {
		return bay_id;
	}
	
	public void setBayId (String bayId) {
		this.bay_id = bayId;
	}
	/*public Date getNewTimeCreated() {
		return newTimeCreated;
	}

	public void setNewTimeCreated(Date newTimeCreated) {
		this.newTimeCreated = newTimeCreated;
	}
	
	public Date getNewTimeUpdated() {
		return newTimeUpdated;
	}

	public void setNewTimeUpdated(Date newTimeUpdated) {
		this.newTimeUpdated = newTimeUpdated;
	}
*/
	@Override
	public String toString() {
		return "WrmData [id=" + id + ", userId=" + userId + ", ctId=" + ctId + ", waterId=" + waterId + ", elementId="
				+ elementId + ", elementValue=" + elementValue + ", criteria=" + criteria + ", groupId=" + groupId + ", timeCreated="
				+ timeCreated + ", timeUpdated=" + timeUpdated + "]";
	}


}
