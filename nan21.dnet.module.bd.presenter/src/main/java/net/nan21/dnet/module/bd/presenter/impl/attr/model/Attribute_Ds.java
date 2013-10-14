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
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;

@Ds(entity = Attribute.class, sort = {@SortField(field = Attribute_Ds.f_code)})
@RefLookups({
		@RefLookup(refId = Attribute_Ds.f_categoryId, namedQuery = AttributeCategory.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Attribute_Ds.f_category)}),
		@RefLookup(refId = Attribute_Ds.f_uomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Attribute_Ds.f_uom)})})
public class Attribute_Ds extends AbstractTypeWithCodeDs<Attribute> {

	public static final String f_dataType = "dataType";
	public static final String f_listOfvalues = "listOfvalues";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";

	@DsField
	private String dataType;

	@DsField
	private String listOfvalues;

	@DsField(join = "left", path = "category.id")
	private String categoryId;

	@DsField(join = "left", path = "category.code")
	private String category;

	@DsField(join = "left", path = "uom.id")
	private String uomId;

	@DsField(join = "left", path = "uom.code")
	private String uom;

	public Attribute_Ds() {
		super();
	}

	public Attribute_Ds(Attribute e) {
		super(e);
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getListOfvalues() {
		return this.listOfvalues;
	}

	public void setListOfvalues(String listOfvalues) {
		this.listOfvalues = listOfvalues;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUomId() {
		return this.uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
}
