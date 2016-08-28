package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * WRMDataResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WRMDataResponse   {
  private String userId = null;

  private String groupId = null;

  private String bayId = null;

  private String waterId = null;

  private String elementId = null;

  private Float elementValue = null;

  private String criteria = null;

  public WRMDataResponse userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * unique identifier of the user
   * @return userId
  **/
  @ApiModelProperty(value = "unique identifier of the user")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public WRMDataResponse groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * unique identifier of the group
   * @return groupId
  **/
  @ApiModelProperty(value = "unique identifier of the group")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public WRMDataResponse bayId(String bayId) {
    this.bayId = bayId;
    return this;
  }

   /**
   * unique identifier of the bay
   * @return bayId
  **/
  @ApiModelProperty(value = "unique identifier of the bay")
  public String getBayId() {
    return bayId;
  }

  public void setBayId(String bayId) {
    this.bayId = bayId;
  }

  public WRMDataResponse waterId(String waterId) {
    this.waterId = waterId;
    return this;
  }

   /**
   * name of the water type
   * @return waterId
  **/
  @ApiModelProperty(value = "name of the water type")
  public String getWaterId() {
    return waterId;
  }

  public void setWaterId(String waterId) {
    this.waterId = waterId;
  }

  public WRMDataResponse elementId(String elementId) {
    this.elementId = elementId;
    return this;
  }

   /**
   * name of the element
   * @return elementId
  **/
  @ApiModelProperty(value = "name of the element")
  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public WRMDataResponse elementValue(Float elementValue) {
    this.elementValue = elementValue;
    return this;
  }

   /**
   * value of element measured
   * @return elementValue
  **/
  @ApiModelProperty(value = "value of element measured")
  public Float getElementValue() {
    return elementValue;
  }

  public void setElementValue(Float elementValue) {
    this.elementValue = elementValue;
  }

  public WRMDataResponse criteria(String criteria) {
    this.criteria = criteria;
    return this;
  }

   /**
   * Get criteria
   * @return criteria
  **/
  @ApiModelProperty(value = "")
  public String getCriteria() {
    return criteria;
  }

  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataResponse wRMDataResponse = (WRMDataResponse) o;
    return Objects.equals(this.userId, wRMDataResponse.userId) &&
        Objects.equals(this.groupId, wRMDataResponse.groupId) &&
        Objects.equals(this.bayId, wRMDataResponse.bayId) &&
        Objects.equals(this.waterId, wRMDataResponse.waterId) &&
        Objects.equals(this.elementId, wRMDataResponse.elementId) &&
        Objects.equals(this.elementValue, wRMDataResponse.elementValue) &&
        Objects.equals(this.criteria, wRMDataResponse.criteria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, groupId, bayId, waterId, elementId, elementValue, criteria);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataResponse {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    bayId: ").append(toIndentedString(bayId)).append("\n");
    sb.append("    waterId: ").append(toIndentedString(waterId)).append("\n");
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    elementValue: ").append(toIndentedString(elementValue)).append("\n");
    sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
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

