/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.elem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 */
@NamedQueries({@NamedQuery(name = Engine.NQ_FIND_BY_NAME, query = "SELECT e FROM Engine e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Engine.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Engine.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class Engine extends AbstractType {

	public static final String TABLE_NAME = "BD_ELEM_CTX";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Engine.findByName";

	@NotBlank
	@Column(name = "TYPE", nullable = false, length = 32)
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
