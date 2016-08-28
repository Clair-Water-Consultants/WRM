package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * BayRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class BayRequest   {
  private String name = null;

  private String groupId = null;

  public BayRequest name(String name) {
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

  public BayRequest groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * id of the group the bay belongs to
   * @return groupId
  **/
  @ApiModelProperty(value = "id of the group the bay belongs to")
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
    BayRequest bayRequest = (BayRequest) o;
    return Objects.equals(this.name, bayRequest.name) &&
        Objects.equals(this.groupId, bayRequest.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BayRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

