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
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;

@Ds(entity = AttributeSetAttribute.class, sort = {
		@SortField(field = AttributeSetAttribute_Ds.f_attributeSet),
		@SortField(field = AttributeSetAttribute_Ds.f_attributeSubSet),
		@SortField(field = AttributeSetAttribute_Ds.f_sequenceNo)})
@RefLookups({
		@RefLookup(refId = AttributeSetAttribute_Ds.f_attributeId, namedQuery = Attribute.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = AttributeSetAttribute_Ds.f_attribute)}),
		@RefLookup(refId = AttributeSetAttribute_Ds.f_attributeSetId, namedQuery = AttributeSet.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = AttributeSetAttribute_Ds.f_attributeSet)}),
		@RefLookup(refId = AttributeSetAttribute_Ds.f_attributeSubSetId, namedQuery = AttributeSubSet.NQ_FIND_BY_CODE_PRIMITIVE, params = {
				@Param(name = "attributeSetId", field = AttributeSetAttribute_Ds.f_attributeSetId),
				@Param(name = "code", field = AttributeSetAttribute_Ds.f_attributeSubSet)})})
public class AttributeSetAttribute_Ds
		extends
			AbstractAuditableDs<AttributeSetAttribute> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_inDescription = "inDescription";
	public static final String f_attributeId = "attributeId";
	public static final String f_attribute = "attribute";
	public static final String f_attributeName = "attributeName";
	public static final String f_attributeSetId = "attributeSetId";
	public static final String f_attributeSet = "attributeSet";
	public static final String f_attributeSetName = "attributeSetName";
	public static final String f_attributeSubSetId = "attributeSubSetId";
	public static final String f_attributeSubSet = "attributeSubSet";
	public static final String f_attributeSubSetName = "attributeSubSetName";

	@DsField
	private Integer sequenceNo;

	@DsField
	private Boolean inDescription;

	@DsField(join = "left", path = "attribute.id")
	private String attributeId;

	@DsField(join = "left", path = "attribute.code")
	private String attribute;

	@DsField(join = "left", path = "attribute.name")
	private String attributeName;

	@DsField(join = "left", path = "attributeSet.id")
	private String attributeSetId;

	@DsField(join = "left", path = "attributeSet.code")
	private String attributeSet;

	@DsField(join = "left", path = "attributeSet.name")
	private String attributeSetName;

	@DsField(join = "left", path = "attributeSubSet.id")
	private String attributeSubSetId;

	@DsField(join = "left", path = "attributeSubSet.code")
	private String attributeSubSet;

	@DsField(join = "left", path = "attributeSubSet.name")
	private String attributeSubSetName;

	public AttributeSetAttribute_Ds() {
		super();
	}

	public AttributeSetAttribute_Ds(AttributeSetAttribute e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Boolean getInDescription() {
		return this.inDescription;
	}

	public void setInDescription(Boolean inDescription) {
		this.inDescription = inDescription;
	}

	public String getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
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

	public String getAttributeSetName() {
		return this.attributeSetName;
	}

	public void setAttributeSetName(String attributeSetName) {
		this.attributeSetName = attributeSetName;
	}

	public String getAttributeSubSetId() {
		return this.attributeSubSetId;
	}

	public void setAttributeSubSetId(String attributeSubSetId) {
		this.attributeSubSetId = attributeSubSetId;
	}

	public String getAttributeSubSet() {
		return this.attributeSubSet;
	}

	public void setAttributeSubSet(String attributeSubSet) {
		this.attributeSubSet = attributeSubSet;
	}

	public String getAttributeSubSetName() {
		return this.attributeSubSetName;
	}

	public void setAttributeSubSetName(String attributeSubSetName) {
		this.attributeSubSetName = attributeSubSetName;
	}
}
