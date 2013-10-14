/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.comment.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;

@Ds(entity = CommentType.class, sort = {@SortField(field = CommentTypeLov_Ds.f_name)})
public class CommentTypeLov_Ds extends AbstractTypeLov<CommentType> {

	public static final String f_targetFqn = "targetFqn";
	public static final String f_targetType = "targetType";

	@DsField
	private String targetFqn;

	@DsField
	private String targetType;

	public CommentTypeLov_Ds() {
		super();
	}

	public CommentTypeLov_Ds(CommentType e) {
		super(e);
	}

	public String getTargetFqn() {
		return this.targetFqn;
	}

	public void setTargetFqn(String targetFqn) {
		this.targetFqn = targetFqn;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
}
