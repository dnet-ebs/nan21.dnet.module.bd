/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.comment;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;

/**
 * Interface to expose business functions specific for {@link CommentType} domain
 * entity.
 */
public interface ICommentTypeService extends IEntityService<CommentType> {

	/**
	 * Find by unique key
	 */
	public CommentType findByName(String name);
}
