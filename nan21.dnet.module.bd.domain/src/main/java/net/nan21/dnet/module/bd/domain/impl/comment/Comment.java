/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = Comment.TABLE_NAME)
public class Comment extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_NOTE";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "TEXT", length = 4000)
	private String text;

	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CommentType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private CommentType type;

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

	public CommentType getType() {
		return this.type;
	}

	public void setType(CommentType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
