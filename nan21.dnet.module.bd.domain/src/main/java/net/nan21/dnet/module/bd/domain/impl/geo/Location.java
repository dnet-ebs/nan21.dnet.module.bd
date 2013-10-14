/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.geo.City;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 */
@Entity
@Table(name = Location.TABLE_NAME)
public class Location extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_GEO_LOCATION";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "REGIONNAME", length = 255)
	private String regionName;

	@Column(name = "CITYNAME", length = 255)
	private String cityName;

	@Column(name = "ADRESS", length = 400)
	private String adress;

	@Column(name = "ZIP", length = 32)
	private String zip;

	/** Adress used for shipping.*/
	@NotNull
	@Column(name = "FORSHIPPING", nullable = false)
	private Boolean forShipping;

	/** Adress used for invoicing.*/
	@NotNull
	@Column(name = "FORBILLING", nullable = false)
	private Boolean forBilling;

	/** Adress used for post-mails.*/
	@NotNull
	@Column(name = "FORMAILING", nullable = false)
	private Boolean forMailing;

	/** Reference used to link addresses to different entity types. */
	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Region.class)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "ID")
	private Region region;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
	@JoinColumn(name = "CITY_ID", referencedColumnName = "ID")
	private City city;

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Boolean getForShipping() {
		return this.forShipping;
	}

	public void setForShipping(Boolean forShipping) {
		this.forShipping = forShipping;
	}

	public Boolean getForBilling() {
		return this.forBilling;
	}

	public void setForBilling(Boolean forBilling) {
		this.forBilling = forBilling;
	}

	public Boolean getForMailing() {
		return this.forMailing;
	}

	public void setForMailing(Boolean forMailing) {
		this.forMailing = forMailing;
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	@Transient
	public String getAsString() {
		return this.adress + " " + this.cityName;
	}

	public void setAsString(String asString) {
	}

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

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		if (city != null) {
			this.__validate_client_context__(city.getClientId());
		}
		this.city = city;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.forShipping == null) {
			this.forShipping = new Boolean(false);
		}
		if (this.forBilling == null) {
			this.forBilling = new Boolean(false);
		}
		if (this.forMailing == null) {
			this.forMailing = new Boolean(false);
		}
	}
}
