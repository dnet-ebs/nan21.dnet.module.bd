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
import net.nan21.dnet.module.bd.business.api.elem.IElementTypeService;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementCategory;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementType;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Repository functionality for {@link ElementType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementType_Service extends AbstractEntityService<ElementType>
		implements
			IElementTypeService {

	public ElementType_Service() {
		super();
	}

	public ElementType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementType> getEntityClass() {
		return ElementType.class;
	}
	/**
	 * Find by unique key
	 */
	public ElementType findByEngine_name(Engine engine, String name) {
		return (ElementType) this
				.getEntityManager()
				.createNamedQuery(ElementType.NQ_FIND_BY_ENGINE_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engine", engine).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ElementType findByEngine_name(Long engineId, String name) {
		return (ElementType) this
				.getEntityManager()
				.createNamedQuery(ElementType.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: engine
	 */
	public List<ElementType> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}
	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementType> findByEngineId(String engineId) {
		return (List<ElementType>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementType e where e.clientId = :clientId and e.engine.id = :engineId",
						ElementType.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).getResultList();
	}
	/**
	 * Find by reference: category
	 */
	public List<ElementType> findByCategory(ElementCategory category) {
		return this.findByCategoryId(category.getId());
	}
	/**
	 * Find by ID of reference: category.id
	 */
	public List<ElementType> findByCategoryId(String categoryId) {
		return (List<ElementType>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementType e where e.clientId = :clientId and e.category.id = :categoryId",
						ElementType.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId).getResultList();
	}
}
