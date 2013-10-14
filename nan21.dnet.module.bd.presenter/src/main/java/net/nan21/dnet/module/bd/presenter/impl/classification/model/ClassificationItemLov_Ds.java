/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.classification.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationItem;

@Ds(entity = ClassificationItem.class, sort = {@SortField(field = ClassificationItemLov_Ds.f_code)})
public class ClassificationItemLov_Ds
		extends
			AbstractTypeWithCodeLov<ClassificationItem> {

	public static final String f_classSystemId = "classSystemId";

	@DsField(join = "left", path = "classSystem.id")
	private String classSystemId;

	public ClassificationItemLov_Ds() {
		super();
	}

	public ClassificationItemLov_Ds(ClassificationItem e) {
		super(e);
	}

	public String getClassSystemId() {
		return this.classSystemId;
	}

	public void setClassSystemId(String classSystemId) {
		this.classSystemId = classSystemId;
	}
}
