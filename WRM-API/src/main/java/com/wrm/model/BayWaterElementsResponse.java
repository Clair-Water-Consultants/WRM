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

public class BayWaterElementsResponse   {
	private String ctId = null;

	private String waterId = null;

	private String elementId = null;

	private String groupId = null;

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

	public BayWaterElementsResponse groupId(String groupId) {
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


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BayWaterElementsResponse bayResponse = (BayWaterElementsResponse) o;
		return Objects.equals(this.ctId, bayResponse.ctId) &&
				Objects.equals(this.waterId, bayResponse.waterId) &&
				Objects.equals(this.elementId, bayResponse.elementId) &&
				Objects.equals(this.groupId, bayResponse.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ctId, waterId, elementId, groupId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BayWaterElementsResponse {\n");

		sb.append("    bayId: ").append(toIndentedString(ctId)).append("\n");
		sb.append("    waterId: ").append(toIndentedString(waterId)).append("\n");
		sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
		sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
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

