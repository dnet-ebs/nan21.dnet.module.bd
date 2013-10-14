/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;

@Ds(entity = AttributeCategory.class, sort = {@SortField(field = AttributeCategoryLov_Ds.f_code)})
public class AttributeCategoryLov_Ds
		extends
			AbstractTypeWithCodeLov<AttributeCategory> {

	public AttributeCategoryLov_Ds() {
		super();
	}

	public AttributeCategoryLov_Ds(AttributeCategory e) {
		super(e);
	}
}
