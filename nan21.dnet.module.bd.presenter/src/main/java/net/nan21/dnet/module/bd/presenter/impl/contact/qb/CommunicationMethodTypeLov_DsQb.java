/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.contact.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.bd.presenter.impl.contact.model.CommunicationMethodTypeLov_Ds;

import net.nan21.dnet.core.api.session.Session;

public class CommunicationMethodTypeLov_DsQb
		extends
			QueryBuilderWithJpql<CommunicationMethodTypeLov_Ds, CommunicationMethodTypeLov_Ds, Object> {

	@Override
	public void setFilter(CommunicationMethodTypeLov_Ds filter) {
		if (filter.getTargetType() == null || filter.getTargetType().equals("")) {
			filter.setTargetType("N/A");
		}
		super.setFilter(filter);
	}
}
