package com.wrm.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class WRMDataBay   {
  private String bayId = null;

  private WRMDataWater[] waters = null;


   /**
   * name of the element
   * @return elementId
  **/
  @ApiModelProperty(value = "name of the element")
  public String getBayId() {
    return bayId;
  }

  public void setBayId(String bayId) {
    this.bayId = bayId;
  }

   /**
   * value of element measured
   * @return elementValue
  **/
  @ApiModelProperty(value = "value of element measured")
  public List<WRMDataWater> getWaters() {
    return Arrays.asList(waters);
  }

  public void setWaters(WRMDataWater[] waters) {
    this.waters = Arrays.copyOf(waters, waters.length);
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataBay wRMDataBay = (WRMDataBay) o;
    return Objects.equals(this.bayId, wRMDataBay.bayId) &&
        Objects.equals(this.waters, wRMDataBay.waters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bayId, waters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataBay {\n");
    
    sb.append("    bayId: ").append(toIndentedString(bayId)).append("\n");
    sb.append("    waters: ").append(toIndentedString(waters)).append("\n");
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

