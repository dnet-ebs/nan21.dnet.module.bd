/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.uom;

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

/** Measuring units definition. */
@NamedQueries({
		@NamedQuery(name = UomType.NQ_FIND_BY_CODE, query = "SELECT e FROM UomType e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = UomType.NQ_FIND_BY_NAME, query = "SELECT e FROM UomType e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = UomType.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = UomType.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = UomType.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class UomType extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_UOM_TYPE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "UomType.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "UomType.findByName";

	@NotBlank
	@Column(name = "CATEGORY", nullable = false, length = 16)
	private String category;

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
