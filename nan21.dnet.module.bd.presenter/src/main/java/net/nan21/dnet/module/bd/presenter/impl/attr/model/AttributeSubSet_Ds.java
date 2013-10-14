/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;

@Ds(entity = AttributeSubSet.class, sort = {
		@SortField(field = AttributeSubSet_Ds.f_attributeSet),
		@SortField(field = AttributeSubSet_Ds.f_sequenceNo)})
@RefLookups({@RefLookup(refId = AttributeSubSet_Ds.f_attributeSetId, namedQuery = AttributeSet.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = AttributeSubSet_Ds.f_attributeSet)})})
public class AttributeSubSet_Ds extends AbstractTypeWithCodeDs<AttributeSubSet> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_attributeSetId = "attributeSetId";
	public static final String f_attributeSet = "attributeSet";

	@DsField
	private Integer sequenceNo;

	@DsField(join = "left", path = "attributeSet.id")
	private String attributeSetId;

	@DsField(join = "left", path = "attributeSet.code")
	private String attributeSet;

	public AttributeSubSet_Ds() {
		super();
	}

	public AttributeSubSet_Ds(AttributeSubSet e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getAttributeSetId() {
		return this.attributeSetId;
	}

	public void setAttributeSetId(String attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public String getAttributeSet() {
		return this.attributeSet;
	}

	public void setAttributeSet(String attributeSet) {
		this.attributeSet = attributeSet;
	}
}
