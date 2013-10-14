/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** Currencies definition  */
@NamedQueries({
		@NamedQuery(name = Currency.NQ_FIND_BY_CODE, query = "SELECT e FROM Currency e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Currency.NQ_FIND_BY_NAME, query = "SELECT e FROM Currency e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Currency.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Currency.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Currency.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class Currency extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_CRNCY";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Currency.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Currency.findByName";

	@Column(name = "ISO3", length = 3)
	private String iso3;

	@Column(name = "SYMBOL", length = 255)
	private String symbol;

	@Column(name = "STANDARDPRECISION", precision = 1)
	private Integer standardPrecision;

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getStandardPrecision() {
		return this.standardPrecision;
	}

	public void setStandardPrecision(Integer standardPrecision) {
		this.standardPrecision = standardPrecision;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
