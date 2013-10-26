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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** Exchange rate values. */
@NamedQueries({
		@NamedQuery(name = CurrencyXRate.NQ_FIND_BY_VALID, query = "SELECT e FROM CurrencyXRate e WHERE e.clientId = :clientId and e.provider = :provider and e.source = :source and e.target = :target and e.validAt = :validAt", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = CurrencyXRate.NQ_FIND_BY_VALID_PRIMITIVE, query = "SELECT e FROM CurrencyXRate e WHERE e.clientId = :clientId and e.provider.id = :providerId and e.source.id = :sourceId and e.target.id = :targetId and e.validAt = :validAt", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CurrencyXRate.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = CurrencyXRate.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "PROVIDER_ID", "SOURCE_ID",
		"TARGET_ID", "VALIDAT"})})
public class CurrencyXRate extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_CRNCY_XRATE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Valid.
	 */
	public static final String NQ_FIND_BY_VALID = "CurrencyXRate.findByValid";
	/**
	 * Named query find by unique key: Valid using the ID field for references.
	 */
	public static final String NQ_FIND_BY_VALID_PRIMITIVE = "CurrencyXRate.findByValid_PRIMITIVE";

	/** Exchange rate valid at. */
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDAT", nullable = false)
	private Date validAt;

	/** Exchange rate value. */
	@NotNull
	@Column(name = "VALUE", nullable = false, precision = 21, scale = 6)
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
			this.value = new BigDecimal("1");
		}
	}
}
