package com.wrm.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class WRMDataTime   {
  private String time = null;

  private WRMDataBay[] bays = null;


   /**
   * name of the element
   * @return elementId
  **/
  @ApiModelProperty(value = "name of the element")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

   /**
   * value of element measured
   * @return elementValue
  **/
  @ApiModelProperty(value = "value of element measured")
  public List<WRMDataBay> getBays() {
    return Arrays.asList(bays);
  }

  public void setBays(WRMDataBay[] bays) {
    this.bays = Arrays.copyOf(bays, bays.length);
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataTime wRMDataTime = (WRMDataTime) o;
    return Objects.equals(this.time, wRMDataTime.time) &&
        Objects.equals(this.bays, wRMDataTime.bays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, bays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataTime {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    bays: ").append(toIndentedString(bays)).append("\n");
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

