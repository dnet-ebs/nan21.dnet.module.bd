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
 * Attribute group definition. The attribute-group is linked to business object(s)
 */
@NamedQueries({
		@NamedQuery(name = AttributeSet.NQ_FIND_BY_CODE, query = "SELECT e FROM AttributeSet e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AttributeSet.NQ_FIND_BY_NAME, query = "SELECT e FROM AttributeSet e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AttributeSet.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = AttributeSet.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = AttributeSet.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class AttributeSet extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_ATTRSET";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "AttributeSet.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AttributeSet.findByName";

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
