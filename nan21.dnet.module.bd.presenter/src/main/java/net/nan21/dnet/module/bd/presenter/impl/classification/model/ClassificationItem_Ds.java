/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.classification.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationItem;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

@Ds(entity = ClassificationItem.class, sort = {@SortField(field = ClassificationItem_Ds.f_code)})
@RefLookups({@RefLookup(refId = ClassificationItem_Ds.f_classSystemId, namedQuery = ClassificationSystem.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ClassificationItem_Ds.f_classSystem)})})
public class ClassificationItem_Ds
		extends
			AbstractTypeWithCodeDs<ClassificationItem> {

	public static final String f_classSystemId = "classSystemId";
	public static final String f_classSystem = "classSystem";

	@DsField(join = "left", path = "classSystem.id")
	private String classSystemId;

	@DsField(join = "left", path = "classSystem.code")
	private String classSystem;

	public ClassificationItem_Ds() {
		super();
	}

	public ClassificationItem_Ds(ClassificationItem e) {
		super(e);
	}

	public String getClassSystemId() {
		return this.classSystemId;
	}

	public void setClassSystemId(String classSystemId) {
		this.classSystemId = classSystemId;
	}

	public String getClassSystem() {
		return this.classSystem;
	}

	public void setClassSystem(String classSystem) {
		this.classSystem = classSystem;
	}
}
