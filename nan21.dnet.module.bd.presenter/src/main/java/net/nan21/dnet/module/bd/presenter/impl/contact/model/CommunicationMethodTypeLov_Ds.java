/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.contact.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;

@Ds(entity = CommunicationMethodType.class, sort = {@SortField(field = CommunicationMethodTypeLov_Ds.f_name)})
public class CommunicationMethodTypeLov_Ds
		extends
			AbstractTypeLov<CommunicationMethodType> {

	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";

	@DsField(fetch = false, jpqlFilter = "  e.refid in (select t.sourceRefId from TargetRule t where  t.targetAlias = :targetAlias and  t.targetType = :targetType and t.clientId = :clientId ) ")
	private String targetAlias;

	@DsField(fetch = false)
	private String targetType;

	public CommunicationMethodTypeLov_Ds() {
		super();
	}

	public CommunicationMethodTypeLov_Ds(CommunicationMethodType e) {
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
