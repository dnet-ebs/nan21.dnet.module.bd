/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.other.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.other.LookupItem;

@Ds(entity = LookupItem.class, sort = {@SortField(field = LookupItem_Ds.f_code)})
public class LookupItem_Ds extends AbstractTypeWithCodeDs<LookupItem> {

	public static final String f_type = "type";

	@DsField
	private String type;

	public LookupItem_Ds() {
		super();
	}

	public LookupItem_Ds(LookupItem e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
