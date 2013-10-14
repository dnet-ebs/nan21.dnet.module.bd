/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.other;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import org.hibernate.validator.constraints.NotBlank;

/** Define rules to dynamically linked objects. */
@Entity
@Table(name = TargetRule.TABLE_NAME)
public class TargetRule extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_TARGET_RULE";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "SOURCEREFID", nullable = false, length = 64)
	private String sourceRefId;

	@NotBlank
	@Column(name = "TARGETALIAS", nullable = false, length = 255)
	private String targetAlias;

	@NotBlank
	@Column(name = "TARGETTYPE", nullable = false, length = 255)
	private String targetType;

	public String getSourceRefId() {
		return this.sourceRefId;
	}

	public void setSourceRefId(String sourceRefId) {
		this.sourceRefId = sourceRefId;
	}

	public String getTargetAlias() {
		return this.targetAlias;
	}

	public void setTargetAlias(String targetAlias) {
		this.targetAlias = targetAlias;
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
