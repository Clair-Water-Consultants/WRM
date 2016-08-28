package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * ElementRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class ElementRequest   {
  private String name = null;

  private String units = null;

  private String description = null;

  private Float lowerLimit = null;

  private Float upperLimit = null;

  public ElementRequest name(String name) {
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

  public ElementRequest units(String units) {
    this.units = units;
    return this;
  }

   /**
   * unit of the element
   * @return units
  **/
  @ApiModelProperty(value = "unit of the element")
  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }

  public ElementRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description of the element
   * @return description
  **/
  @ApiModelProperty(value = "description of the element")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ElementRequest lowerLimit(Float lowerLimit) {
    this.lowerLimit = lowerLimit;
    return this;
  }

   /**
   * lower limit of the measured element
   * @return lowerLimit
  **/
  @ApiModelProperty(value = "lower limit of the measured element")
  public Float getLowerLimit() {
    return lowerLimit;
  }

  public void setLowerLimit(Float lowerLimit) {
    this.lowerLimit = lowerLimit;
  }

  public ElementRequest upperLimit(Float upperLimit) {
    this.upperLimit = upperLimit;
    return this;
  }

   /**
   * lower limit of the measured element
   * @return upperLimit
  **/
  @ApiModelProperty(value = "lower limit of the measured element")
  public Float getUpperLimit() {
    return upperLimit;
  }

  public void setUpperLimit(Float upperLimit) {
    this.upperLimit = upperLimit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementRequest elementRequest = (ElementRequest) o;
    return Objects.equals(this.name, elementRequest.name) &&
        Objects.equals(this.units, elementRequest.units) &&
        Objects.equals(this.description, elementRequest.description) &&
        Objects.equals(this.lowerLimit, elementRequest.lowerLimit) &&
        Objects.equals(this.upperLimit, elementRequest.upperLimit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, units, description, lowerLimit, upperLimit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lowerLimit: ").append(toIndentedString(lowerLimit)).append("\n");
    sb.append("    upperLimit: ").append(toIndentedString(upperLimit)).append("\n");
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

