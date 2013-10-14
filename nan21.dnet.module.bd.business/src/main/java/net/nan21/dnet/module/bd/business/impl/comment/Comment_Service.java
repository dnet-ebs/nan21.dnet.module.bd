/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.comment;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.comment.ICommentService;
import net.nan21.dnet.module.bd.domain.impl.comment.Comment;
import net.nan21.dnet.module.bd.domain.impl.comment.CommentType;

/**
 * Repository functionality for {@link Comment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Comment_Service extends AbstractEntityService<Comment>
		implements
			ICommentService {

	public Comment_Service() {
		super();
	}

	public Comment_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Comment> getEntityClass() {
		return Comment.class;
	}
	/**
	 * Find by reference: type
	 */
	public List<Comment> findByType(CommentType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<Comment> findByTypeId(String typeId) {
		return (List<Comment>) this
				.getEntityManager()
				.createQuery(
						"select e from Comment e where e.clientId = :clientId and e.type.id = :typeId",
						Comment.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
}
