/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.classification.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.bd.presenter.impl.classification.model.ClassificationSystemLov_Ds;

import net.nan21.dnet.core.api.session.Session;

public class ClassificationSystemLov_DsQb
		extends
			QueryBuilderWithJpql<ClassificationSystemLov_Ds, ClassificationSystemLov_Ds, Object> {

	@Override
	public void setFilter(ClassificationSystemLov_Ds filter) {
		if (filter.getTargetType() == null || filter.getTargetType().equals("")) {
			filter.setTargetType("N/A");
		}
		super.setFilter(filter);
	}
}
