/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.currency;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;

@Entity
@Table(name = CurrencyXRateAverage.TABLE_NAME)
public class CurrencyXRateAverage extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_CRNCY_XRATE_AVG";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false)
	private Date validFrom;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO", nullable = false)
	private Date validTo;

	@NotNull
	@Column(name = "VALUE", nullable = false, precision = 18, scale = 2)
	private BigDecimal value;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CurrencyXRateProvider.class)
	@JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
	private CurrencyXRateProvider provider;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "SOURCE_ID", referencedColumnName = "ID")
	private Currency source;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "TARGET_ID", referencedColumnName = "ID")
	private Currency target;

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public CurrencyXRateProvider getProvider() {
		return this.provider;
	}

	public void setProvider(CurrencyXRateProvider provider) {
		if (provider != null) {
			this.__validate_client_context__(provider.getClientId());
		}
		this.provider = provider;
	}

	public Currency getSource() {
		return this.source;
	}

	public void setSource(Currency source) {
		if (source != null) {
			this.__validate_client_context__(source.getClientId());
		}
		this.source = source;
	}

	public Currency getTarget() {
		return this.target;
	}

	public void setTarget(Currency target) {
		if (target != null) {
			this.__validate_client_context__(target.getClientId());
		}
		this.target = target;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.value == null) {
			this.value = new BigDecimal("0");
		}
	}
}
