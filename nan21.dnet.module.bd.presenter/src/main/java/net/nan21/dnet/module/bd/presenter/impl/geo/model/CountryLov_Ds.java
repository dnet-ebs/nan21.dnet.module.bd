/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.geo.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;

@Ds(entity = Country.class, sort = {@SortField(field = CountryLov_Ds.f_code)})
public class CountryLov_Ds extends AbstractTypeWithCodeLov<Country> {

	public CountryLov_Ds() {
		super();
	}

	public CountryLov_Ds(Country e) {
		super(e);
	}
}
