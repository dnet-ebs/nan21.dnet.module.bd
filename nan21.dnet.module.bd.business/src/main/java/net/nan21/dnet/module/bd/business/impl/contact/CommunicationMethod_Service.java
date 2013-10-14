/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.contact;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.contact.ICommunicationMethodService;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethod;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;

/**
 * Repository functionality for {@link CommunicationMethod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CommunicationMethod_Service
		extends
			AbstractEntityService<CommunicationMethod>
		implements
			ICommunicationMethodService {

	public CommunicationMethod_Service() {
		super();
	}

	public CommunicationMethod_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CommunicationMethod> getEntityClass() {
		return CommunicationMethod.class;
	}
	/**
	 * Find by reference: type
	 */
	public List<CommunicationMethod> findByType(CommunicationMethodType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<CommunicationMethod> findByTypeId(String typeId) {
		return (List<CommunicationMethod>) this
				.getEntityManager()
				.createQuery(
						"select e from CommunicationMethod e where e.clientId = :clientId and e.type.id = :typeId",
						CommunicationMethod.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
}
