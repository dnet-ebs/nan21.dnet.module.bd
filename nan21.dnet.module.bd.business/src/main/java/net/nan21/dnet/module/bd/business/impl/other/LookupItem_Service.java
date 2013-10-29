/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.other;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.other.ILookupItemService;
import net.nan21.dnet.module.bd.domain.impl.other.LookupItem;

/**
 * Repository functionality for {@link LookupItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class LookupItem_Service extends AbstractEntityService<LookupItem>
		implements
			ILookupItemService {

	public LookupItem_Service() {
		super();
	}

	public LookupItem_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<LookupItem> getEntityClass() {
		return LookupItem.class;
	}
	/**
	 * Find by unique key
	 */
	public LookupItem findByCode(String type, String code) {
		return (LookupItem) this
				.getEntityManager()
				.createNamedQuery(LookupItem.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("type", type).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public LookupItem findByName(String type, String name) {
		return (LookupItem) this
				.getEntityManager()
				.createNamedQuery(LookupItem.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("type", type).setParameter("name", name)
				.getSingleResult();
	}
}
