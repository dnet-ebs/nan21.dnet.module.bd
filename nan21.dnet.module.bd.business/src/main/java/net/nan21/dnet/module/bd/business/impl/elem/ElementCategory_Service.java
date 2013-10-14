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
import net.nan21.dnet.module.bd.business.api.elem.IElementCategoryService;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementCategory;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Repository functionality for {@link ElementCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementCategory_Service
		extends
			AbstractEntityService<ElementCategory>
		implements
			IElementCategoryService {

	public ElementCategory_Service() {
		super();
	}

	public ElementCategory_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementCategory> getEntityClass() {
		return ElementCategory.class;
	}
	/**
	 * Find by unique key
	 */
	public ElementCategory findByEngine_name(Engine engine, String name) {
		return (ElementCategory) this
				.getEntityManager()
				.createNamedQuery(ElementCategory.NQ_FIND_BY_ENGINE_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engine", engine).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ElementCategory findByEngine_name(Long engineId, String name) {
		return (ElementCategory) this
				.getEntityManager()
				.createNamedQuery(
						ElementCategory.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: engine
	 */
	public List<ElementCategory> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}
	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementCategory> findByEngineId(String engineId) {
		return (List<ElementCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementCategory e where e.clientId = :clientId and e.engine.id = :engineId",
						ElementCategory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).getResultList();
	}
}
