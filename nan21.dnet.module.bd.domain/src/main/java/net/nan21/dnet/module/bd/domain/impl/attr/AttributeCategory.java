/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.attr;

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

/**
 * Attribute category definition.
 */
@NamedQueries({
		@NamedQuery(name = AttributeCategory.NQ_FIND_BY_CODE, query = "SELECT e FROM AttributeCategory e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AttributeCategory.NQ_FIND_BY_NAME, query = "SELECT e FROM AttributeCategory e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AttributeCategory.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = AttributeCategory.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = AttributeCategory.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class AttributeCategory extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_ATTR_CTG";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "AttributeCategory.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AttributeCategory.findByName";

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
