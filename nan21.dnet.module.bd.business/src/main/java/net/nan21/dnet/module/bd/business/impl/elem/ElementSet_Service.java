/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.elem;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.elem.IElementSetService;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSet;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Repository functionality for {@link ElementSet} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementSet_Service extends AbstractEntityService<ElementSet>
		implements
			IElementSetService {

	public ElementSet_Service() {
		super();
	}

	public ElementSet_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementSet> getEntityClass() {
		return ElementSet.class;
	}
	/**
	 * Find by unique key
	 */
	public ElementSet findByEngine_name(Engine engine, String name) {
		return (ElementSet) this
				.getEntityManager()
				.createNamedQuery(ElementSet.NQ_FIND_BY_ENGINE_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engine", engine).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ElementSet findByEngine_name(Long engineId, String name) {
		return (ElementSet) this
				.getEntityManager()
				.createNamedQuery(ElementSet.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: engine
	 */
	public List<ElementSet> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}
	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementSet> findByEngineId(String engineId) {
		return (List<ElementSet>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementSet e where e.clientId = :clientId and e.engine.id = :engineId",
						ElementSet.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).getResultList();
	}
}
