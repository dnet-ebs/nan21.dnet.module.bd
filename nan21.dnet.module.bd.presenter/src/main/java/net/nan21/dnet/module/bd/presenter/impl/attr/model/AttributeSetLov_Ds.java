/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;

@Ds(entity = AttributeSet.class, sort = {@SortField(field = AttributeSetLov_Ds.f_code)})
public class AttributeSetLov_Ds extends AbstractTypeWithCodeLov<AttributeSet> {

	public AttributeSetLov_Ds() {
		super();
	}

	public AttributeSetLov_Ds(AttributeSet e) {
		super(e);
	}
}
