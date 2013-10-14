/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.currency.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;

@Ds(entity = Currency.class, sort = {@SortField(field = Currency_Ds.f_code)})
public class Currency_Ds extends AbstractTypeWithCodeDs<Currency> {

	public static final String f_iso3 = "iso3";
	public static final String f_standardPrecision = "standardPrecision";
	public static final String f_symbol = "symbol";

	@DsField
	private String iso3;

	@DsField
	private Integer standardPrecision;

	@DsField
	private String symbol;

	public Currency_Ds() {
		super();
	}

	public Currency_Ds(Currency e) {
		super(e);
	}

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public Integer getStandardPrecision() {
		return this.standardPrecision;
	}

	public void setStandardPrecision(Integer standardPrecision) {
		this.standardPrecision = standardPrecision;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
