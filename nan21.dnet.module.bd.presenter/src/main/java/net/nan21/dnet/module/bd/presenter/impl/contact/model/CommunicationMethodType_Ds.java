/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.contact.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;

@Ds(entity = CommunicationMethodType.class, sort = {@SortField(field = CommunicationMethodType_Ds.f_name)})
public class CommunicationMethodType_Ds
		extends
			AbstractTypeDs<CommunicationMethodType> {

	public static final String f_type = "type";

	@DsField
	private String type;

	public CommunicationMethodType_Ds() {
		super();
	}

	public CommunicationMethodType_Ds(CommunicationMethodType e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
