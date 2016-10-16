package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * BayResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class BayResponse   {
	private String id = null;

	private String name = null;

	private String groupId = null;

	private String userId = null;

	public BayResponse id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique identifier of the bay
	 * @return id
	 **/
	@ApiModelProperty(value = "unique identifier of the bay")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BayResponse name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the bay
	 * @return name
	 **/
	@ApiModelProperty(value = "name of the bay")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BayResponse groupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * group id the bay belongs to
	 * @return groupId
	 **/
	@ApiModelProperty(value = "group id the bay belongs to")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public BayResponse userId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * user id the bay belongs to
	 * @return groupId
	 **/
	@ApiModelProperty(value = "user id the bay belongs to")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BayResponse bayResponse = (BayResponse) o;
		return Objects.equals(this.id, bayResponse.id) &&
				Objects.equals(this.name, bayResponse.name) &&
				Objects.equals(this.groupId, bayResponse.groupId) &&
				Objects.equals(this.userId, bayResponse.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, groupId, userId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BayResponse {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

