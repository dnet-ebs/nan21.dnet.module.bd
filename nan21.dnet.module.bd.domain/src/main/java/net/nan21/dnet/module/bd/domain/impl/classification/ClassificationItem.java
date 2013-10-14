/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.classification;

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
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

@NamedQueries({
		@NamedQuery(name = ClassificationItem.NQ_FIND_BY_SYSCODE, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :clientId and e.classSystem = :classSystem and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ClassificationItem.NQ_FIND_BY_SYSCODE_PRIMITIVE, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :clientId and e.classSystem.id = :classSystemId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ClassificationItem.NQ_FIND_BY_SYSNAME, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :clientId and e.classSystem = :classSystem and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ClassificationItem.NQ_FIND_BY_SYSNAME_PRIMITIVE, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :clientId and e.classSystem.id = :classSystemId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ClassificationItem.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = ClassificationItem.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CLASSSYSTEM_ID", "CODE"}),
		@UniqueConstraint(name = ClassificationItem.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "CLASSSYSTEM_ID", "NAME"})})
public class ClassificationItem extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_CLSF_ITEM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Syscode.
	 */
	public static final String NQ_FIND_BY_SYSCODE = "ClassificationItem.findBySyscode";
	/**
	 * Named query find by unique key: Syscode using the ID field for references.
	 */
	public static final String NQ_FIND_BY_SYSCODE_PRIMITIVE = "ClassificationItem.findBySyscode_PRIMITIVE";
	/**
	 * Named query find by unique key: Sysname.
	 */
	public static final String NQ_FIND_BY_SYSNAME = "ClassificationItem.findBySysname";
	/**
	 * Named query find by unique key: Sysname using the ID field for references.
	 */
	public static final String NQ_FIND_BY_SYSNAME_PRIMITIVE = "ClassificationItem.findBySysname_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ClassificationSystem.class)
	@JoinColumn(name = "CLASSSYSTEM_ID", referencedColumnName = "ID")
	private ClassificationSystem classSystem;

	public ClassificationSystem getClassSystem() {
		return this.classSystem;
	}

	public void setClassSystem(ClassificationSystem classSystem) {
		if (classSystem != null) {
			this.__validate_client_context__(classSystem.getClientId());
		}
		this.classSystem = classSystem;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
