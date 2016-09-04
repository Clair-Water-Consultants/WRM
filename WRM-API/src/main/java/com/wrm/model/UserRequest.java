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

public class UserRequest   {
  private String name = null;

  private String pass = null;

  private String groupId = null;

  private String firstName = null;

  private String lastName = null;

  private String emailId = null;

  private DateTime createdTime = null;

  private DateTime updatedTime = null;

  public UserRequest name(String name) {
    this.name = name;
    return this;
  }

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

  public UserRequest pass(String pass) {
    this.pass = pass;
    return this;
  }

   /**
   * password of the user
   * @return pass
  **/
  @ApiModelProperty(value = "password of the user")
  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public UserRequest groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * groupId that this user belongs to
   * @return groupId
  **/
  @ApiModelProperty(value = "groupId that this user belongs to")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public UserRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * first name of the user
   * @return firstName
  **/
  @ApiModelProperty(value = "first name of the user")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * last name of the user
   * @return lastName
  **/
  @ApiModelProperty(value = "last name of the user")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserRequest emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }

   /**
   * emailId of the user
   * @return emailId
  **/
  @ApiModelProperty(value = "emailId of the user")
  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public UserRequest createdTime(DateTime createdTime) {
    this.createdTime = createdTime;
    return this;
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

  public UserRequest updatedTime(DateTime updatedTime) {
    this.updatedTime = updatedTime;
    return this;
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
    UserRequest userRequest = (UserRequest) o;
    return Objects.equals(this.name, userRequest.name) &&
        Objects.equals(this.pass, userRequest.pass) &&
        Objects.equals(this.groupId, userRequest.groupId) &&
        Objects.equals(this.firstName, userRequest.firstName) &&
        Objects.equals(this.lastName, userRequest.lastName) &&
        Objects.equals(this.emailId, userRequest.emailId) &&
        Objects.equals(this.createdTime, userRequest.createdTime) &&
        Objects.equals(this.updatedTime, userRequest.updatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, pass, groupId, firstName, lastName, emailId, createdTime, updatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    pass: ").append(toIndentedString(pass)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
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

