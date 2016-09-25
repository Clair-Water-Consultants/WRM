package com.wrm.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class WRMDataWater   {
  private String waterId = null;

  private WRMDataElement[] elements = null;


   /**
   * name of the element
   * @return elementId
  **/
  @ApiModelProperty(value = "name of the element")
  public String getWaterId() {
    return waterId;
  }

  public void setWaterId(String waterId) {
    this.waterId = waterId;
  }

   /**
   * value of element measured
   * @return elementValue
  **/
  @ApiModelProperty(value = "value of element measured")
  public List<WRMDataElement> getElements() {
    return Arrays.asList(elements);
  }

  public void setElements(WRMDataElement[] elements) {
    this.elements = Arrays.copyOf(elements, elements.length);
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataWater wRMDataWater = (WRMDataWater) o;
    return Objects.equals(this.waterId, wRMDataWater.waterId) &&
        Objects.equals(this.elements, wRMDataWater.elements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(waterId, elements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataWater {\n");
    
    sb.append("    waterId: ").append(toIndentedString(waterId)).append("\n");
    sb.append("    elementValue: ").append(toIndentedString(elements)).append("\n");
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

