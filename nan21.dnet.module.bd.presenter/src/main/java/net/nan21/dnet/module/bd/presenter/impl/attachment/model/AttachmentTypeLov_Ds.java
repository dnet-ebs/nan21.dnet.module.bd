/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attachment.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.bd.domain.impl.attachment.AttachmentType;

@Ds(entity = AttachmentType.class, sort = {@SortField(field = AttachmentTypeLov_Ds.f_name)})
public class AttachmentTypeLov_Ds extends AbstractTypeLov<AttachmentType> {

	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";

	@DsField(fetch = false, jpqlFilter = "  e.refid in (select t.sourceRefId from TargetRule t where  t.targetAlias = :targetAlias and  t.targetType = :targetType ) ")
	private String targetAlias;

	@DsField(fetch = false)
	private String targetType;

	public AttachmentTypeLov_Ds() {
		super();
	}

	public AttachmentTypeLov_Ds(AttachmentType e) {
		super(e);
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
