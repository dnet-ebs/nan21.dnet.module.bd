/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = Country.NQ_FIND_BY_CODE, query = "SELECT e FROM Country e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Country.NQ_FIND_BY_NAME, query = "SELECT e FROM Country e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Country.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Country.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Country.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class Country extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_GEO_CNTRY";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Country.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Country.findByName";

	@Column(name = "ISO2", length = 2)
	private String iso2;

	@Column(name = "ISO3", length = 3)
	private String iso3;

	@NotNull
	@Column(name = "HASREGIONS", nullable = false)
	private Boolean hasRegions;

	public String getIso2() {
		return this.iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public Boolean getHasRegions() {
		return this.hasRegions;
	}

	public void setHasRegions(Boolean hasRegions) {
		this.hasRegions = hasRegions;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.hasRegions == null) {
			this.hasRegions = new Boolean(false);
		}
	}
}
