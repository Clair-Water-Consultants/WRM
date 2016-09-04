package com.wrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * UserListResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

public class UserListResponse   {
  private List<UserResponse> user = new ArrayList<UserResponse>();

  public UserListResponse user(List<UserResponse> user) {
    this.user = user;
    return this;
  }

  public UserListResponse addUserItem(UserResponse userItem) {
    this.user.add(userItem);
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public List<UserResponse> getUser() {
    return user;
  }

  public void setUser(List<UserResponse> user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserListResponse userListResponse = (UserListResponse) o;
    return Objects.equals(this.user, userListResponse.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserListResponse {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

