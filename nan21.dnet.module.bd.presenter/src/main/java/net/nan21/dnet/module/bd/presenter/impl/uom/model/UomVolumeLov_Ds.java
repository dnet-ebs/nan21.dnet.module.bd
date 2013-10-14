/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.uom.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;

@Ds(entity = Uom.class, jpqlWhere = " e.type.category = 'volume' ", sort = {@SortField(field = UomVolumeLov_Ds.f_code)})
public class UomVolumeLov_Ds extends AbstractTypeWithCodeLov<Uom> {

	public UomVolumeLov_Ds() {
		super();
	}

	public UomVolumeLov_Ds(Uom e) {
		super(e);
	}
}
