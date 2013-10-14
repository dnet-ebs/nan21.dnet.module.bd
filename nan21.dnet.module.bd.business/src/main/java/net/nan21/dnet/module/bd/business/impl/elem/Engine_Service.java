/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.elem;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.elem.IEngineService;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Repository functionality for {@link Engine} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Engine_Service extends AbstractEntityService<Engine>
		implements
			IEngineService {

	public Engine_Service() {
		super();
	}

	public Engine_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Engine> getEntityClass() {
		return Engine.class;
	}
	/**
	 * Find by unique key
	 */
	public Engine findByName(String name) {
		return (Engine) this
				.getEntityManager()
				.createNamedQuery(Engine.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
