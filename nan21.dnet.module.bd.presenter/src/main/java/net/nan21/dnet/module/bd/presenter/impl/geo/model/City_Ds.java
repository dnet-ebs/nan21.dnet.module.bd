/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.geo.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.bd.domain.impl.geo.City;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

@Ds(entity = City.class, sort = {@SortField(field = City_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = City_Ds.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = City_Ds.f_country)}),
		@RefLookup(refId = City_Ds.f_regionId, namedQuery = Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE, params = {
				@Param(name = "countryId", field = City_Ds.f_countryId),
				@Param(name = "code", field = City_Ds.f_region)})})
public class City_Ds extends AbstractTypeDs<City> {

	public static final String f_countryId = "countryId";
	public static final String f_country = "country";
	public static final String f_regionId = "regionId";
	public static final String f_region = "region";

	@DsField(join = "left", path = "country.id")
	private String countryId;

	@DsField(join = "left", path = "country.code")
	private String country;

	@DsField(join = "left", path = "region.id")
	private String regionId;

	@DsField(join = "left", path = "region.code")
	private String region;

	public City_Ds() {
		super();
	}

	public City_Ds(City e) {
		super(e);
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
