/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.currency.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;

@Ds(entity = Currency.class, sort = {@SortField(field = CurrencyLov_Ds.f_code)})
public class CurrencyLov_Ds extends AbstractTypeWithCodeLov<Currency> {

	public CurrencyLov_Ds() {
		super();
	}

	public CurrencyLov_Ds(Currency e) {
		super(e);
	}
}
