package com.wrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * BayListResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class BayWaterElementsListResponse   {
  private List<BayWaterElementsResponse> assocList = new ArrayList<BayWaterElementsResponse>();


  public BayWaterElementsListResponse addAssocItem(BayWaterElementsResponse assocItem) {
    this.assocList.add(assocItem);
    return this;
  }

   /**
   * Get bays
   * @return bays
  **/
  @ApiModelProperty(value = "")
  public List<BayWaterElementsResponse> getAssocList() {
    return assocList;
  }

  public void setAssocList(List<BayWaterElementsResponse> assocList) {
    this.assocList = assocList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BayWaterElementsListResponse assocListResponse = (BayWaterElementsListResponse) o;
    return Objects.equals(this.assocList, assocListResponse.assocList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assocList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BayWaterElementsListResponse {\n");
    
    sb.append("    assocList: ").append(toIndentedString(assocList)).append("\n");
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

