/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.geo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * 
 */
@Entity
@Table(name = City.TABLE_NAME)
public class City extends AbstractType {

	public static final String TABLE_NAME = "BD_GEO_CITY";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Region.class)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "ID")
	private Region region;

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		if (country != null) {
			this.__validate_client_context__(country.getClientId());
		}
		this.country = country;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		if (region != null) {
			this.__validate_client_context__(region.getClientId());
		}
		this.region = region;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
