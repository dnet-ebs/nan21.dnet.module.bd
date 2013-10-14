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

@Ds(entity = Uom.class, jpqlWhere = " e.type.category = 'mass' ", sort = {@SortField(field = UomMassLov_Ds.f_code)})
public class UomMassLov_Ds extends AbstractTypeWithCodeLov<Uom> {

	public UomMassLov_Ds() {
		super();
	}

	public UomMassLov_Ds(Uom e) {
		super(e);
	}
}
