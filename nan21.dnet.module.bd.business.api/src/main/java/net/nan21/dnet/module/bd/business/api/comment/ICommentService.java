/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.comment;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.comment.Comment;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;

/**
 * Interface to expose business functions specific for {@link Comment} domain
 * entity.
 */
public interface ICommentService extends IEntityService<Comment> {

	/**
	 * Find by reference: type
	 */
	public List<Comment> findByType(CommentType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Comment> findByTypeId(String typeId);
}
