/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;

@Ds(entity = Attribute.class, sort = {@SortField(field = AttributeLov_Ds.f_code)})
public class AttributeLov_Ds extends AbstractTypeWithCodeLov<Attribute> {

	public AttributeLov_Ds() {
		super();
	}

	public AttributeLov_Ds(Attribute e) {
		super(e);
	}
}
