package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * WaterTypeResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WaterTypeResponse   {
  private String id = null;

  private String type = null;

  private String description = null;

  public WaterTypeResponse id(String id) {
    this.id = id;
    return this;
  }

   /**
   * unique identifier of the water type
   * @return id
  **/
  @ApiModelProperty(value = "unique identifier of the water type")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WaterTypeResponse type(String type) {
    this.type = type;
    return this;
  }

   /**
   * name of the water type
   * @return type
  **/
  @ApiModelProperty(value = "name of the water type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public WaterTypeResponse description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description of the water type
   * @return description
  **/
  @ApiModelProperty(value = "description of the water type")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterTypeResponse waterTypeResponse = (WaterTypeResponse) o;
    return Objects.equals(this.id, waterTypeResponse.id) &&
        Objects.equals(this.type, waterTypeResponse.type) &&
        Objects.equals(this.description, waterTypeResponse.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterTypeResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

