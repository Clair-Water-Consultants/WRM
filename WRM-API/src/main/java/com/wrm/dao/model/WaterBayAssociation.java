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
@Table(name = "BAY_WATER_ASSOCIATION")
@AssociationOverrides( {
    @AssociationOverride(name = "primary.water",
        joinColumns = @JoinColumn(name = "WATER_ID")),
    @AssociationOverride(name = "primary.bay",
        joinColumns = @JoinColumn(name = "BAY_ID"))})
public class WaterBayAssociation {
	@Embeddable
	public static class Primary implements java.io.Serializable {
		private static final long serialVersionUID = 1L;

		@ManyToOne(cascade = CascadeType.ALL)
		Water water;
		@ManyToOne(cascade = CascadeType.ALL)
		Bay bay;

		public Primary() {
		}

		public Primary(Water water, Bay bay) {
			this.water = water;
			this.bay = bay;
		}

		public Water getWater() {
			return water;
		}

		public void setWater(Water water) {
			this.water = water;
		}

		public Bay getBay() {
			return bay;
		}

		public void setBay(Bay bay) {
			this.bay = bay;
		}

		@Override
		public String toString() {
			return "Primary [water=" + water + ", bay=" + bay + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bay == null) ? 0 : bay.hashCode());
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
			if (bay == null) {
				if (other.bay != null)
					return false;
			} else if (!bay.equals(other.bay))
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

	public void setPrimary(Water water, Bay bay) {
		this.primary = new Primary(water, bay);
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
		return "WaterBayAssociation [id=" + primary + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}
	
	
}
