/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.uom.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.uom.UomType;

@Ds(entity = UomType.class, sort = {@SortField(field = UomType_Ds.f_code)})
public class UomType_Ds extends AbstractTypeWithCodeDs<UomType> {

	public static final String f_category = "category";

	@DsField
	private String category;

	public UomType_Ds() {
		super();
	}

	public UomType_Ds(UomType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
