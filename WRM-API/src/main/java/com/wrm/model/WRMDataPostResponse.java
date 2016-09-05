package com.wrm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * WRMDataPostResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class WRMDataPostResponse   {
  private String status = null;

  public WRMDataPostResponse (String status) {
	    this.status = status;
	  }
  
  public WRMDataPostResponse status(String status) {
    this.status = status;
    return this;
  }

   /**
   * status of wrmdata insert operation
   * @return status
  **/
  @ApiModelProperty(value = "status of wrmdata insert operation")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WRMDataPostResponse wRMDataPostResponse = (WRMDataPostResponse) o;
    return Objects.equals(this.status, wRMDataPostResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WRMDataPostResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

