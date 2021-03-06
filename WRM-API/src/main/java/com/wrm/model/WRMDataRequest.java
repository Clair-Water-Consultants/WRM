package com.wrm.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

/**
 * WRMDataRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WRMDataRequest {
	
	@NotNull(message = "user id cannot be null")
	@NotEmpty(message = "user id cannot be empty")
	private String userId = null;

	@NotNull(message = "bay id cannot be null")
	@NotEmpty(message = "bay id cannot be empty")
	private String ctId = null;

	@NotNull(message = "water id cannot be null")
	@NotEmpty(message = "water id cannot be empty")
	private String waterId = null;

	@NotNull(message = "element id cannot be null")
	@NotEmpty(message = "element id cannot be empty")
	private String elementId = null;

	private double elementValue = 0;

	@NotNull(message = "criteria cannot be null")
	@NotEmpty(message = "criteria cannot be empty")
	private String criteria = null;

	private String timeCreated = null;

	private String bayId = null;
	
	@NotNull(message = "group id cannot be null")
	@NotEmpty(message = "group id cannot be empty")
	private String groupId = null;


	public WRMDataRequest userId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * unique identifier of the user
	 * 
	 * @return userId
	 **/
	@ApiModelProperty(value = "unique identifier of the user")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public WRMDataRequest bayId(String bayId) {
		this.bayId = bayId;
		return this;
	}

	/**
	 * unique identifier of the bay
	 * 
	 * @return bayId
	 **/
	@ApiModelProperty(value = "unique identifier of the bay")
	public String getBayId() {
		return bayId;
	}

	public void setBayId(String bayId) {
		this.bayId = bayId;
	}


	@ApiModelProperty(value = "unique identifier of the bay")
	public String getCtId() {
		return ctId;
	}

	public void setCtId(String ctId) {
		this.ctId = ctId;
	}
	
	
	@ApiModelProperty(value = "unique identifier of the group")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public WRMDataRequest waterId(String waterId) {
		this.waterId = waterId;
		return this;
	}

	/**
	 * name of the water type
	 * 
	 * @return waterId
	 **/
	@ApiModelProperty(value = "name of the water type")
	public String getWaterId() {
		return waterId;
	}

	public void setWaterId(String waterId) {
		this.waterId = waterId;
	}

	public WRMDataRequest elementId(String elementId) {
		this.elementId = elementId;
		return this;
	}

	/**
	 * name of the element
	 * 
	 * @return elementId
	 **/
	@ApiModelProperty(value = "name of the element")
	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public WRMDataRequest elementValue(Float elementValue) {
		this.elementValue = elementValue;
		return this;
	}

	/**
	 * value of element measured
	 * 
	 * @return elementValue
	 **/
	@ApiModelProperty(value = "value of element measured")
	public double getElementValue() {
		return elementValue;
	}

	public void setElementValue(double elementValue) {
		this.elementValue = elementValue;
	}

	public WRMDataRequest criteria(String criteria) {
		this.criteria = criteria;
		return this;
	}

	/**
	 * sample values for time of data entry
	 * 
	 * @return criteria
	 **/
	@ApiModelProperty(value = "sample values for time of data entry")
	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public WRMDataRequest timeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
		return this;
	}

	/**
	 * date and time of record captured
	 * 
	 * @return timeCreated
	 **/
	@ApiModelProperty(value = "date and time of record captured")
	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WRMDataRequest wRMDataRequest = (WRMDataRequest) o;
		return Objects.equals(this.userId, wRMDataRequest.userId) && Objects.equals(this.bayId, wRMDataRequest.bayId)
				&& Objects.equals(this.ctId, wRMDataRequest.ctId)
				&& Objects.equals(this.waterId, wRMDataRequest.waterId)
				&& Objects.equals(this.elementId, wRMDataRequest.elementId)
				&& Objects.equals(this.elementValue, wRMDataRequest.elementValue)
				&& Objects.equals(this.criteria, wRMDataRequest.criteria)
				&& Objects.equals(this.timeCreated, wRMDataRequest.timeCreated);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, bayId, waterId, elementId, elementValue, criteria, timeCreated);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WRMDataRequest {\n");

		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
		sb.append("    bayId: ").append(toIndentedString(bayId)).append("\n");
		sb.append("    ctId: ").append(toIndentedString(ctId)).append("\n");
		sb.append("    waterId: ").append(toIndentedString(waterId)).append("\n");
		sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
		sb.append("    elementValue: ").append(toIndentedString(elementValue)).append("\n");
		sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
		sb.append("    timeCreated: ").append(toIndentedString(timeCreated)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
