/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.other;

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
import org.hibernate.validator.constraints.NotBlank;

/**
 * Lookup item 
 */
@NamedQueries({
		@NamedQuery(name = LookupItem.NQ_FIND_BY_CODE, query = "SELECT e FROM LookupItem e WHERE e.clientId = :clientId and e.type = :type and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = LookupItem.NQ_FIND_BY_NAME, query = "SELECT e FROM LookupItem e WHERE e.clientId = :clientId and e.type = :type and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = LookupItem.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = LookupItem.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "TYPE", "CODE"}),
		@UniqueConstraint(name = LookupItem.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "TYPE", "NAME"})})
public class LookupItem extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_LKP_ITEMT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "LookupItem.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "LookupItem.findByName";

	@NotBlank
	@Column(name = "TYPE", nullable = false, length = 64)
	private String type;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
