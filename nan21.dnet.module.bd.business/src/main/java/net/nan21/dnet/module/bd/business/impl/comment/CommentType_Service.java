/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.comment;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.comment.ICommentTypeService;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;

/**
 * Repository functionality for {@link CommentType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CommentType_Service extends AbstractEntityService<CommentType>
		implements
			ICommentTypeService {

	public CommentType_Service() {
		super();
	}

	public CommentType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CommentType> getEntityClass() {
		return CommentType.class;
	}
	/**
	 * Find by unique key
	 */
	public CommentType findByName(String name) {
		return (CommentType) this
				.getEntityManager()
				.createNamedQuery(CommentType.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
