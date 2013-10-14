/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.geo;

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
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = Region.NQ_FIND_BY_CODEANDCOUNTRY, query = "SELECT e FROM Region e WHERE e.clientId = :clientId and e.country = :country and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE, query = "SELECT e FROM Region e WHERE e.clientId = :clientId and e.country.id = :countryId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Region.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Region.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "COUNTRY_ID", "CODE"})})
public class Region extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_GEO_REGION";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: CodeAndCountry.
	 */
	public static final String NQ_FIND_BY_CODEANDCOUNTRY = "Region.findByCodeAndCountry";
	/**
	 * Named query find by unique key: CodeAndCountry using the ID field for references.
	 */
	public static final String NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE = "Region.findByCodeAndCountry_PRIMITIVE";

	@Column(name = "ISO", length = 32)
	private String iso;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	private Country country;

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		if (country != null) {
			this.__validate_client_context__(country.getClientId());
		}
		this.country = country;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
