package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;




/**
 * UserRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

public class CompanyGroupRequest   {
  private String id = null;

  private String name = null;

  private String description = null;

  private String address = null;

  private DateTime createdTime = null;

  private DateTime updatedTime = null;


   /**
   * unique userid (alphanumberic) of the user
   * @return name
  **/
  @ApiModelProperty(value = "unique userid (alphanumberic) of the user")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

   /**
   * groupId that this user belongs to
   * @return groupId
  **/
  @ApiModelProperty(value = "groupId that this user belongs to")
  public String getId() {
    return id;
  }

  public void setId(String Id) {
    this.id = Id;
  }

   /**
   * first name of the user
   * @return firstName
  **/
  @ApiModelProperty(value = "first name of the user")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

   /**
   * last name of the user
   * @return lastName
  **/
  @ApiModelProperty(value = "last name of the user")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

   /**
   * time when the user is added to database
   * @return createdTime
  **/
  @ApiModelProperty(value = "time when the user is added to database")
  public DateTime getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(DateTime createdTime) {
    this.createdTime = createdTime;
  }

   /**
   * time this user row is recently updated
   * @return updatedTime
  **/
  @ApiModelProperty(value = "time this user row is recently updated")
  public DateTime getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(DateTime updatedTime) {
    this.updatedTime = updatedTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompanyGroupRequest request = (CompanyGroupRequest) o;
    return Objects.equals(this.name, request.name) &&
        Objects.equals(this.id, request.id) &&
        Objects.equals(this.description, request.description) &&
        Objects.equals(this.address, request.address) &&
        Objects.equals(this.createdTime, request.createdTime) &&
        Objects.equals(this.updatedTime, request.updatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, description, address, createdTime, updatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    updatedTime: ").append(toIndentedString(updatedTime)).append("\n");
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

