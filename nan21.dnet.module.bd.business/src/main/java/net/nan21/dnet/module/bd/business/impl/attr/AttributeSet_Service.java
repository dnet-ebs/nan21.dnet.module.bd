/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.attr;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.attr.IAttributeSetService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;

/**
 * Repository functionality for {@link AttributeSet} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeSet_Service extends AbstractEntityService<AttributeSet>
		implements
			IAttributeSetService {

	public AttributeSet_Service() {
		super();
	}

	public AttributeSet_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeSet> getEntityClass() {
		return AttributeSet.class;
	}
	/**
	 * Find by unique key
	 */
	public AttributeSet findByCode(String code) {
		return (AttributeSet) this
				.getEntityManager()
				.createNamedQuery(AttributeSet.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AttributeSet findByName(String name) {
		return (AttributeSet) this
				.getEntityManager()
				.createNamedQuery(AttributeSet.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
