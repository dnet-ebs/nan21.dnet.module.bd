/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.comment;

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

@NamedQueries({@NamedQuery(name = CommentType.NQ_FIND_BY_NAME, query = "SELECT e FROM CommentType e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CommentType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = CommentType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class CommentType extends AbstractType {

	public static final String TABLE_NAME = "BD_NOTE_TYPE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "CommentType.findByName";

	@NotBlank
	@Column(name = "TARGETFQN", nullable = false, length = 255)
	private String targetFqn;

	@Column(name = "TARGETTYPE", length = 32)
	private String targetType;

	public String getTargetFqn() {
		return this.targetFqn;
	}

	public void setTargetFqn(String targetFqn) {
		this.targetFqn = targetFqn;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
