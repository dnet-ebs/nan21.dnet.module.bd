/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.classification.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

@Ds(entity = ClassificationSystem.class, sort = {@SortField(field = ClassificationSystem_Ds.f_code)})
public class ClassificationSystem_Ds
		extends
			AbstractTypeWithCodeDs<ClassificationSystem> {

	public static final String f_internal = "internal";

	@DsField
	private Boolean internal;

	public ClassificationSystem_Ds() {
		super();
	}

	public ClassificationSystem_Ds(ClassificationSystem e) {
		super(e);
	}

	public Boolean getInternal() {
		return this.internal;
	}

	public void setInternal(Boolean internal) {
		this.internal = internal;
	}
}
