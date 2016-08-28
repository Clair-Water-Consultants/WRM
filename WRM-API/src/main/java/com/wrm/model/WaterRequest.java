package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * WaterRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WaterRequest   {
  private String name = null;

  private String description = null;

  public WaterRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name of the element
   * @return name
  **/
  @ApiModelProperty(value = "name of the element")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WaterRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * unit of the element
   * @return description
  **/
  @ApiModelProperty(value = "unit of the element")
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
    WaterRequest waterRequest = (WaterRequest) o;
    return Objects.equals(this.name, waterRequest.name) &&
        Objects.equals(this.description, waterRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

