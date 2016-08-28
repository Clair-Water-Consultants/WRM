package com.wrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * BayListResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class BayListResponse   {
  private List<BayResponse> bays = new ArrayList<BayResponse>();

  public BayListResponse bays(List<BayResponse> bays) {
    this.bays = bays;
    return this;
  }

  public BayListResponse addBaysItem(BayResponse baysItem) {
    this.bays.add(baysItem);
    return this;
  }

   /**
   * Get bays
   * @return bays
  **/
  @ApiModelProperty(value = "")
  public List<BayResponse> getBays() {
    return bays;
  }

  public void setBays(List<BayResponse> bays) {
    this.bays = bays;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BayListResponse bayListResponse = (BayListResponse) o;
    return Objects.equals(this.bays, bayListResponse.bays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BayListResponse {\n");
    
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

