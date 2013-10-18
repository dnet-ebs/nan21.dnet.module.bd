/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;

@Ds(entity = AttributeSubSet.class, sort = {@SortField(field = AttributeSubSetLov_Ds.f_code)})
public class AttributeSubSetLov_Ds
		extends
			AbstractTypeWithCodeLov<AttributeSubSet> {

	public static final String f_attributeSetId = "attributeSetId";

	@DsField(join = "left", path = "attributeSet.id")
	private String attributeSetId;

	public AttributeSubSetLov_Ds() {
		super();
	}

	public AttributeSubSetLov_Ds(AttributeSubSet e) {
		super(e);
	}

	public String getAttributeSetId() {
		return this.attributeSetId;
	}

	public void setAttributeSetId(String attributeSetId) {
		this.attributeSetId = attributeSetId;
	}
}
