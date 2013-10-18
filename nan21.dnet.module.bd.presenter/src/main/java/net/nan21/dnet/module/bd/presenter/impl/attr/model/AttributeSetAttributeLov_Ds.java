/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableLov;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;

@Ds(entity = AttributeSetAttribute.class, sort = {@SortField(field = AttributeSetAttributeLov_Ds.f_attribute)})
public class AttributeSetAttributeLov_Ds
		extends
			AbstractAuditableLov<AttributeSetAttribute> {

	public static final String f_id = "id";
	public static final String f_attributeId = "attributeId";
	public static final String f_attribute = "attribute";
	public static final String f_attributeName = "attributeName";
	public static final String f_attributeSetId = "attributeSetId";
	public static final String f_attributeSubSetId = "attributeSubSetId";

	@DsField
	private String id;

	@DsField(join = "left", path = "attribute.id")
	private String attributeId;

	@DsField(join = "left", path = "attribute.code")
	private String attribute;

	@DsField(join = "left", path = "attribute.name")
	private String attributeName;

	@DsField(join = "left", path = "attributeSet.id")
	private String attributeSetId;

	@DsField(join = "left", path = "attributeSubSet.id")
	private String attributeSubSetId;

	public AttributeSetAttributeLov_Ds() {
		super();
	}

	public AttributeSetAttributeLov_Ds(AttributeSetAttribute e) {
		super(e);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAttributeSubSetId() {
		return this.attributeSubSetId;
	}

	public void setAttributeSubSetId(String attributeSubSetId) {
		this.attributeSubSetId = attributeSubSetId;
	}
}
