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
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

@Ds(entity = ClassificationSystem.class, sort = {@SortField(field = ClassificationSystemLov_Ds.f_code)})
public class ClassificationSystemLov_Ds
		extends
			AbstractTypeWithCodeLov<ClassificationSystem> {

	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";

	@DsField(fetch = false, jpqlFilter = "  e.refid in (select t.sourceRefId from TargetRule t where  t.targetAlias = :targetAlias and  t.targetType = :targetType and t.clientId = :clientId ) ")
	private String targetAlias;

	@DsField(fetch = false)
	private String targetType;

	public ClassificationSystemLov_Ds() {
		super();
	}

	public ClassificationSystemLov_Ds(ClassificationSystem e) {
		super(e);
	}

	public String getTargetAlias() {
		return this.targetAlias;
	}

	public void setTargetAlias(String targetAlias) {
		this.targetAlias = targetAlias;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
}
