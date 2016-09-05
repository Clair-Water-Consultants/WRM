package com.wrm.dao.model;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "WATER_ELEMENT_ASSOCIATION")
@AssociationOverrides( {
    @AssociationOverride(name = "primary.water",
        joinColumns = @JoinColumn(name = "WATER_ID")),
    @AssociationOverride(name = "primary.element",
        joinColumns = @JoinColumn(name = "ELEMENT_ID"))})
public class WaterElementAssociation {
	@Embeddable
	public static class Primary implements java.io.Serializable {
		private static final long serialVersionUID = 1L;

		@ManyToOne(cascade = CascadeType.ALL)
		Water water;
		@ManyToOne(cascade = CascadeType.ALL)
		Element element;

		public Primary() {
		}

		public Primary(Water water, Element element) {
			this.water = water;
			this.element = element;
		}

		public Water getWater() {
			return water;
		}

		public void setWater(Water water) {
			this.water = water;
		}

		public Element getElement() {
			return element;
		}

		public void setElement(Element element) {
			this.element = element;
		}

		@Override
		public String toString() {
			return "Primary [water=" + water + ", element=" + element + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((element == null) ? 0 : element.hashCode());
			result = prime * result + ((water == null) ? 0 : water.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Primary other = (Primary) obj;
			if (element == null) {
				if (other.element != null)
					return false;
			} else if (!element.equals(other.element))
				return false;
			if (water == null) {
				if (other.water != null)
					return false;
			} else if (!water.equals(other.water))
				return false;
			return true;
		}

	}

	@EmbeddedId
	Primary primary;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	Date createdTime;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TIME")
	Date updatedTime;

	public Primary getPrimary() {
		return primary;
	}

	public void setPrimary(Water water, Element element) {
		this.primary = new Primary(water, element);
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "WaterElementAssociation [id=" + primary + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}
	
	
}
