/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.contact.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;

@Ds(entity = CommunicationMethodType.class, sort = {@SortField(field = CommunicationMethodTypeAllLov_Ds.f_name)})
public class CommunicationMethodTypeAllLov_Ds
		extends
			AbstractTypeLov<CommunicationMethodType> {

	public CommunicationMethodTypeAllLov_Ds() {
		super();
	}

	public CommunicationMethodTypeAllLov_Ds(CommunicationMethodType e) {
		super(e);
	}
}
