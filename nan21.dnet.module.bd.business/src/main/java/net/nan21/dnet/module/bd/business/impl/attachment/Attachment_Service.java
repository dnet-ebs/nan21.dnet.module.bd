/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.attachment;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.domain.impl.attachment.Attachment;
import net.nan21.dnet.module.bd.domain.impl.attachment.AttachmentType;

/**
 * Repository functionality for {@link Attachment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Attachment_Service extends AbstractEntityService<Attachment> {

	public Attachment_Service() {
		super();
	}

	public Attachment_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Attachment> getEntityClass() {
		return Attachment.class;
	}
	/**
	 * Find by reference: type
	 */
	public List<Attachment> findByType(AttachmentType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<Attachment> findByTypeId(String typeId) {
		return (List<Attachment>) this
				.getEntityManager()
				.createQuery(
						"select e from Attachment e where e.clientId = :clientId and e.type.id = :typeId",
						Attachment.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
}
