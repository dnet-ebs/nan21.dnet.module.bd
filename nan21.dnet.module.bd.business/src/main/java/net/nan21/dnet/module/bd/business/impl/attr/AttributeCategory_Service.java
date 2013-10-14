/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.attr;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.attr.IAttributeCategoryService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;

/**
 * Repository functionality for {@link AttributeCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeCategory_Service
		extends
			AbstractEntityService<AttributeCategory>
		implements
			IAttributeCategoryService {

	public AttributeCategory_Service() {
		super();
	}

	public AttributeCategory_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeCategory> getEntityClass() {
		return AttributeCategory.class;
	}
	/**
	 * Find by unique key
	 */
	public AttributeCategory findByCode(String code) {
		return (AttributeCategory) this
				.getEntityManager()
				.createNamedQuery(AttributeCategory.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AttributeCategory findByName(String name) {
		return (AttributeCategory) this
				.getEntityManager()
				.createNamedQuery(AttributeCategory.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
