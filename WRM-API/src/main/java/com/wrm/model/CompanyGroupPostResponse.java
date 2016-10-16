package com.wrm.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * UserPostResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-04T10:25:35.178Z")

public class CompanyGroupPostResponse   {

	private String id = null;
	private String name = null;

	public CompanyGroupPostResponse(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * unique identifier of the added user
	 * @return id
	 **/
	@ApiModelProperty(value = "unique identifier of the added user")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ApiModelProperty(value = "unique identifier of the added user group")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CompanyGroupPostResponse userPostResponse = (CompanyGroupPostResponse) o;
		return Objects.equals(this.id, userPostResponse.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CompanyGroupPostResponse {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name:").append(toIndentedString(name)).append("\n");
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

