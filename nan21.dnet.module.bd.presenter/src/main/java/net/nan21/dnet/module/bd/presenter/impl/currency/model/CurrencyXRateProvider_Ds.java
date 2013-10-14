/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.currency.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;

@Ds(entity = CurrencyXRateProvider.class, sort = {@SortField(field = CurrencyXRateProvider_Ds.f_code)})
public class CurrencyXRateProvider_Ds
		extends
			AbstractTypeWithCodeDs<CurrencyXRateProvider> {

	public CurrencyXRateProvider_Ds() {
		super();
	}

	public CurrencyXRateProvider_Ds(CurrencyXRateProvider e) {
		super(e);
	}
}
