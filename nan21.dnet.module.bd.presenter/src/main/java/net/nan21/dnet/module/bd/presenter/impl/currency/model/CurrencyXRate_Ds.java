/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.currency.model;

import java.math.BigDecimal;
import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRate;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;

@Ds(entity = CurrencyXRate.class, sort = {
		@SortField(field = CurrencyXRate_Ds.f_validAt, desc = true),
		@SortField(field = CurrencyXRate_Ds.f_source),
		@SortField(field = CurrencyXRate_Ds.f_target)})
@RefLookups({
		@RefLookup(refId = CurrencyXRate_Ds.f_sourceId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = CurrencyXRate_Ds.f_source)}),
		@RefLookup(refId = CurrencyXRate_Ds.f_targetId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = CurrencyXRate_Ds.f_target)}),
		@RefLookup(refId = CurrencyXRate_Ds.f_providerId, namedQuery = CurrencyXRateProvider.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = CurrencyXRate_Ds.f_provider)})})
public class CurrencyXRate_Ds extends AbstractAuditableDs<CurrencyXRate> {

	public static final String f_validAt = "validAt";
	public static final String f_value = "value";
	public static final String f_sourceId = "sourceId";
	public static final String f_source = "source";
	public static final String f_targetId = "targetId";
	public static final String f_target = "target";
	public static final String f_providerId = "providerId";
	public static final String f_provider = "provider";

	@DsField
	private Date validAt;

	@DsField
	private BigDecimal value;

	@DsField(join = "left", path = "source.id")
	private String sourceId;

	@DsField(join = "left", path = "source.code")
	private String source;

	@DsField(join = "left", path = "target.id")
	private String targetId;

	@DsField(join = "left", path = "target.code")
	private String target;

	@DsField(join = "left", path = "provider.id")
	private String providerId;

	@DsField(join = "left", path = "provider.code")
	private String provider;

	public CurrencyXRate_Ds() {
		super();
	}

	public CurrencyXRate_Ds(CurrencyXRate e) {
		super(e);
	}

	public Date getValidAt() {
		return this.validAt;
	}

	public void setValidAt(Date validAt) {
		this.validAt = validAt;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTargetId() {
		return this.targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getProviderId() {
		return this.providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
}
