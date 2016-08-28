package com.wrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * WaterTypeListResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WaterTypeListResponse   {
  private List<WaterTypeResponse> watertype = new ArrayList<WaterTypeResponse>();

  public WaterTypeListResponse watertype(List<WaterTypeResponse> watertype) {
    this.watertype = watertype;
    return this;
  }

  public WaterTypeListResponse addWatertypeItem(WaterTypeResponse watertypeItem) {
    this.watertype.add(watertypeItem);
    return this;
  }

   /**
   * Get watertype
   * @return watertype
  **/
  @ApiModelProperty(value = "")
  public List<WaterTypeResponse> getWatertype() {
    return watertype;
  }

  public void setWatertype(List<WaterTypeResponse> watertype) {
    this.watertype = watertype;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterTypeListResponse waterTypeListResponse = (WaterTypeListResponse) o;
    return Objects.equals(this.watertype, waterTypeListResponse.watertype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(watertype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterTypeListResponse {\n");
    
    sb.append("    watertype: ").append(toIndentedString(watertype)).append("\n");
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

