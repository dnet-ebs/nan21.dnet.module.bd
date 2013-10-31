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
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

@Ds(entity = Region.class, sort = {@SortField(field = Region_Ds.f_code)})
@RefLookups({
		@RefLookup(refId = Region_Ds.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Region_Ds.f_country)}),
		@RefLookup(refId = Region_Ds.f_countryId, namedQuery = Country.NQ_FIND_BY_ISO2, params = {@Param(name = "iso2", field = Region_Ds.f_countryIso2)})})
public class Region_Ds extends AbstractTypeWithCodeDs<Region> {

	public static final String f_iso = "iso";
	public static final String f_countryId = "countryId";
	public static final String f_country = "country";
	public static final String f_countryIso2 = "countryIso2";

	@DsField
	private String iso;

	@DsField(join = "left", path = "country.id")
	private String countryId;

	@DsField(join = "left", path = "country.code")
	private String country;

	@DsField(join = "left", path = "country.iso2")
	private String countryIso2;

	public Region_Ds() {
		super();
	}

	public Region_Ds(Region e) {
		super(e);
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
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

	public String getCountryIso2() {
		return this.countryIso2;
	}

	public void setCountryIso2(String countryIso2) {
		this.countryIso2 = countryIso2;
	}
}
