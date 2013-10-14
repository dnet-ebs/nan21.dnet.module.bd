/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attachment.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.bd.presenter.impl.attachment.model.AttachmentTypeLov_Ds;

import net.nan21.dnet.core.api.session.Session;

public class AttachmentTypeLov_DsQb
		extends
			QueryBuilderWithJpql<AttachmentTypeLov_Ds, AttachmentTypeLov_Ds, Object> {

	@Override
	public void setFilter(AttachmentTypeLov_Ds filter) {
		if (filter.getTargetType() == null || filter.getTargetType().equals("")) {
			filter.setTargetType("N/A");
		}
		this.filter = filter;
	}
}
