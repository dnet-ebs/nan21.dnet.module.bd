/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.other.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.bd.domain.impl.other.TargetRule;

@Ds(entity = TargetRule.class)
public class TargetRule_Ds extends AbstractAuditableDs<TargetRule> {

	public static final String f_sourceRefId = "sourceRefId";
	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";

	@DsField
	private String sourceRefId;

	@DsField
	private String targetAlias;

	@DsField
	private String targetType;

	public TargetRule_Ds() {
		super();
	}

	public TargetRule_Ds(TargetRule e) {
		super(e);
	}

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
}
