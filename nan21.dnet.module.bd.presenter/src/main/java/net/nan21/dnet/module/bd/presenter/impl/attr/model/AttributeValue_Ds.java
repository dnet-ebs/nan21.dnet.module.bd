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
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeValue;

@Ds(entity = AttributeValue.class, sort = {
		@SortField(field = AttributeValue_Ds.f_attributeSet),
		@SortField(field = AttributeValue_Ds.f_subSetNo),
		@SortField(field = AttributeValue_Ds.f_setAttributeNo)})
@RefLookups({
		@RefLookup(refId = AttributeValue_Ds.f_attributeId, namedQuery = Attribute.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = AttributeValue_Ds.f_attribute)}),
		@RefLookup(refId = AttributeValue_Ds.f_setAttributeId, namedQuery = AttributeSetAttribute.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "attributeSetId", field = AttributeValue_Ds.f_attributeSetId),
				@Param(name = "attributeId", field = AttributeValue_Ds.f_attributeId)})})
public class AttributeValue_Ds extends AbstractAuditableDs<AttributeValue> {

	public static final String f_value = "value";
	public static final String f_targetRefid = "targetRefid";
	public static final String f_subSetId = "subSetId";
	public static final String f_subSet = "subSet";
	public static final String f_subSetName = "subSetName";
	public static final String f_subSetNo = "subSetNo";
	public static final String f_attributeId = "attributeId";
	public static final String f_attribute = "attribute";
	public static final String f_attributeName = "attributeName";
	public static final String f_attributeDataType = "attributeDataType";
	public static final String f_attributeListOfvalues = "attributeListOfvalues";
	public static final String f_setAttributeId = "setAttributeId";
	public static final String f_setAttributeNo = "setAttributeNo";
	public static final String f_setAttributeListOfvalues = "setAttributeListOfvalues";
	public static final String f_attributeSetId = "attributeSetId";
	public static final String f_attributeSet = "attributeSet";

	@DsField
	private String value;

	@DsField
	private String targetRefid;

	@DsField(join = "left", path = "setAttribute.attributeSubSet.id")
	private String subSetId;

	@DsField(join = "left", path = "setAttribute.attributeSubSet.code")
	private String subSet;

	@DsField(join = "left", path = "setAttribute.attributeSubSet.name")
	private String subSetName;

	@DsField(join = "left", path = "setAttribute.attributeSubSet.sequenceNo")
	private Integer subSetNo;

	@DsField(join = "left", path = "setAttribute.attribute.id")
	private String attributeId;

	@DsField(join = "left", path = "setAttribute.attribute.code")
	private String attribute;

	@DsField(join = "left", path = "setAttribute.attribute.name")
	private String attributeName;

	@DsField(join = "left", path = "setAttribute.attribute.dataType")
	private String attributeDataType;

	@DsField(join = "left", path = "setAttribute.attribute.listOfvalues")
	private String attributeListOfvalues;

	@DsField(join = "left", path = "setAttribute.id")
	private String setAttributeId;

	@DsField(join = "left", path = "setAttribute.sequenceNo")
	private Integer setAttributeNo;

	@DsField(join = "left", path = "setAttribute.listOfvalues")
	private String setAttributeListOfvalues;

	@DsField(join = "left", path = "setAttribute.attributeSet.id")
	private String attributeSetId;

	@DsField(join = "left", path = "setAttribute.attributeSet.code")
	private String attributeSet;

	public AttributeValue_Ds() {
		super();
	}

	public AttributeValue_Ds(AttributeValue e) {
		super(e);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public String getSubSetId() {
		return this.subSetId;
	}

	public void setSubSetId(String subSetId) {
		this.subSetId = subSetId;
	}

	public String getSubSet() {
		return this.subSet;
	}

	public void setSubSet(String subSet) {
		this.subSet = subSet;
	}

	public String getSubSetName() {
		return this.subSetName;
	}

	public void setSubSetName(String subSetName) {
		this.subSetName = subSetName;
	}

	public Integer getSubSetNo() {
		return this.subSetNo;
	}

	public void setSubSetNo(Integer subSetNo) {
		this.subSetNo = subSetNo;
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

	public String getAttributeDataType() {
		return this.attributeDataType;
	}

	public void setAttributeDataType(String attributeDataType) {
		this.attributeDataType = attributeDataType;
	}

	public String getAttributeListOfvalues() {
		return this.attributeListOfvalues;
	}

	public void setAttributeListOfvalues(String attributeListOfvalues) {
		this.attributeListOfvalues = attributeListOfvalues;
	}

	public String getSetAttributeId() {
		return this.setAttributeId;
	}

	public void setSetAttributeId(String setAttributeId) {
		this.setAttributeId = setAttributeId;
	}

	public Integer getSetAttributeNo() {
		return this.setAttributeNo;
	}

	public void setSetAttributeNo(Integer setAttributeNo) {
		this.setAttributeNo = setAttributeNo;
	}

	public String getSetAttributeListOfvalues() {
		return this.setAttributeListOfvalues;
	}

	public void setSetAttributeListOfvalues(String setAttributeListOfvalues) {
		this.setAttributeListOfvalues = setAttributeListOfvalues;
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
