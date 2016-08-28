package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;




/**
 * WRMDataRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WRMDataRequest   {
  private String userId = null;

  private String bayId = null;

  private String waterId = null;

  private String elementId = null;

  private Float elementValue = null;

  private String criteria = null;

  private DateTime timeCreated = null;

  public WRMDataRequest userId(String userId) {
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

  public WRMDataRequest bayId(String bayId) {
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

  public WRMDataRequest waterId(String waterId) {
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

  public WRMDataRequest elementId(String elementId) {
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

  public WRMDataRequest elementValue(Float elementValue) {
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

  public WRMDataRequest criteria(String criteria) {
    this.criteria = criteria;
    return this;
  }

   /**
   * sample values for time of data entry
   * @return criteria
  **/
  @ApiModelProperty(value = "sample values for time of data entry")
  public String getCriteria() {
    return criteria;
  }

  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  public WRMDataRequest timeCreated(DateTime timeCreated) {
    this.timeCreated = timeCreated;
    return this;
  }

   /**
   * date and time of record captured
   * @return timeCreated
  **/
  @ApiModelProperty(value = "date and time of record captured")
  public DateTime getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(DateTime timeCreated) {
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
    return Objects.equals(this.userId, wRMDataRequest.userId) &&
        Objects.equals(this.bayId, wRMDataRequest.bayId) &&
        Objects.equals(this.waterId, wRMDataRequest.waterId) &&
        Objects.equals(this.elementId, wRMDataRequest.elementId) &&
        Objects.equals(this.elementValue, wRMDataRequest.elementValue) &&
        Objects.equals(this.criteria, wRMDataRequest.criteria) &&
        Objects.equals(this.timeCreated, wRMDataRequest.timeCreated);
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

