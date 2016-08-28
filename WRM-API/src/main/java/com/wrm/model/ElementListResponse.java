package com.wrm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * ElementListResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-08-28T09:50:20.362Z")

public class ElementListResponse   {
  private List<ElementResponse> elements = new ArrayList<ElementResponse>();

  public ElementListResponse elements(List<ElementResponse> elements) {
    this.elements = elements;
    return this;
  }

  public ElementListResponse addElementsItem(ElementResponse elementsItem) {
    this.elements.add(elementsItem);
    return this;
  }

   /**
   * Get elements
   * @return elements
  **/
  @ApiModelProperty(value = "")
  public List<ElementResponse> getElements() {
    return elements;
  }

  public void setElements(List<ElementResponse> elements) {
    this.elements = elements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementListResponse elementListResponse = (ElementListResponse) o;
    return Objects.equals(this.elements, elementListResponse.elements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementListResponse {\n");
    
    sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
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

