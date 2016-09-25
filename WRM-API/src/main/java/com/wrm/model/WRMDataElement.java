package com.wrm.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class WRMDataElement   {
  private String elementId = null;

  private Double elementValue = null;


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

   /**
   * value of element measured
   * @return elementValue
  **/
  @ApiModelProperty(value = "value of element measured")
  public Double getElementValue() {
    return elementValue;
  }

  public void setElementValue(Double elementValue) {
    this.elementValue = elementValue;
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataElement wRMDataElement = (WRMDataElement) o;
    return Objects.equals(this.elementId, wRMDataElement.elementId) &&
        Objects.equals(this.elementValue, wRMDataElement.elementValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementId, elementValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataElement {\n");
    
    sb.append("    elementId: ").append(toIndentedString(elementId)).append("\n");
    sb.append("    elementValue: ").append(toIndentedString(elementValue)).append("\n");
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

