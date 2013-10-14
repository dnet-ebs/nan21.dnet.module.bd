/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.comment.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.bd.domain.impl.comment.Comment;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;

@Ds(entity = Comment.class)
@RefLookups({@RefLookup(refId = Comment_Ds.f_typeId, namedQuery = CommentType.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = Comment_Ds.f_type)})})
public class Comment_Ds extends AbstractAuditableDs<Comment> {

	public static final String f_text = "text";
	public static final String f_targetRefid = "targetRefid";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_targetFqn = "targetFqn";
	public static final String f_targetType = "targetType";

	@DsField
	private String text;

	@DsField
	private String targetRefid;

	@DsField(join = "left", path = "type.id")
	private String typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "type.targetFqn")
	private String targetFqn;

	@DsField(join = "left", path = "type.targetType")
	private String targetType;

	public Comment_Ds() {
		super();
	}

	public Comment_Ds(Comment e) {
		super(e);
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
