/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.classification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationItem;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = Classification.TABLE_NAME)
public class Classification extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_CLSF";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@NotBlank
	@Column(name = "TARGETALIAS", nullable = false, length = 64)
	private String targetAlias;

	@Column(name = "TARGETTYPE", length = 255)
	private String targetType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ClassificationSystem.class)
	@JoinColumn(name = "CLASSSYSTEM_ID", referencedColumnName = "ID")
	private ClassificationSystem classSystem;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ClassificationItem.class)
	@JoinColumn(name = "CLASSITEM_ID", referencedColumnName = "ID")
	private ClassificationItem classItem;

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
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

	public ClassificationSystem getClassSystem() {
		return this.classSystem;
	}

	public void setClassSystem(ClassificationSystem classSystem) {
		if (classSystem != null) {
			this.__validate_client_context__(classSystem.getClientId());
		}
		this.classSystem = classSystem;
	}

	public ClassificationItem getClassItem() {
		return this.classItem;
	}

	public void setClassItem(ClassificationItem classItem) {
		if (classItem != null) {
			this.__validate_client_context__(classItem.getClientId());
		}
		this.classItem = classItem;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
