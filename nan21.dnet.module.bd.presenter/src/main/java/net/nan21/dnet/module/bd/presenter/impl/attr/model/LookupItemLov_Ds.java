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
import net.nan21.dnet.module.bd.domain.impl.attr.LookupItem;

@Ds(entity = LookupItem.class, sort = {@SortField(field = LookupItemLov_Ds.f_code)})
public class LookupItemLov_Ds extends AbstractTypeWithCodeLov<LookupItem> {

	public static final String f_type = "type";

	@DsField
	private String type;

	public LookupItemLov_Ds() {
		super();
	}

	public LookupItemLov_Ds(LookupItem e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
