/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.classification.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

@Ds(entity = ClassificationSystem.class, sort = {@SortField(field = ClassificationSystemAllLov_Ds.f_code)})
public class ClassificationSystemAllLov_Ds
		extends
			AbstractTypeWithCodeLov<ClassificationSystem> {

	public ClassificationSystemAllLov_Ds() {
		super();
	}

	public ClassificationSystemAllLov_Ds(ClassificationSystem e) {
		super(e);
	}
}
