package com.wrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * WRMDataListResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WRMDataListResponse   {
  private List<WRMDataResponse> wrmdata = new ArrayList<WRMDataResponse>();

  public WRMDataListResponse wrmdata(List<WRMDataResponse> wrmdata) {
    this.wrmdata = wrmdata;
    return this;
  }

  public WRMDataListResponse addWrmdataItem(WRMDataResponse wrmdataItem) {
    this.wrmdata.add(wrmdataItem);
    return this;
  }

   /**
   * Get wrmdata
   * @return wrmdata
  **/
  @ApiModelProperty(value = "")
  public List<WRMDataResponse> getWrmdata() {
    return wrmdata;
  }

  public void setWrmdata(List<WRMDataResponse> wrmdata) {
    this.wrmdata = wrmdata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataListResponse wRMDataListResponse = (WRMDataListResponse) o;
    return Objects.equals(this.wrmdata, wRMDataListResponse.wrmdata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wrmdata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataListResponse {\n");
    
    sb.append("    wrmdata: ").append(toIndentedString(wrmdata)).append("\n");
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

