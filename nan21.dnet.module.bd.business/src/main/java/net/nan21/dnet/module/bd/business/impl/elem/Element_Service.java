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
import net.nan21.dnet.module.bd.business.api.elem.IElementService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementFormula;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementInput;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementType;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Repository functionality for {@link Element} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Element_Service extends AbstractEntityService<Element>
		implements
			IElementService {

	public Element_Service() {
		super();
	}

	public Element_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Element> getEntityClass() {
		return Element.class;
	}
	/**
	 * Find by unique key
	 */
	public Element findByEngine_code(Engine engine, String code) {
		return (Element) this
				.getEntityManager()
				.createNamedQuery(Element.NQ_FIND_BY_ENGINE_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engine", engine).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Element findByEngine_code(Long engineId, String code) {
		return (Element) this
				.getEntityManager()
				.createNamedQuery(Element.NQ_FIND_BY_ENGINE_CODE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by reference: engine
	 */
	public List<Element> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}
	/**
	 * Find by ID of reference: engine.id
	 */
	public List<Element> findByEngineId(String engineId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select e from Element e where e.clientId = :clientId and e.engine.id = :engineId",
						Element.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("engineId", engineId).getResultList();
	}
	/**
	 * Find by reference: type
	 */
	public List<Element> findByType(ElementType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<Element> findByTypeId(String typeId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select e from Element e where e.clientId = :clientId and e.type.id = :typeId",
						Element.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
	/**
	 * Find by reference: variables
	 */
	public List<Element> findByVariables(ElementInput variables) {
		return this.findByVariablesId(variables.getId());
	}
	/**
	 * Find by ID of reference: variables.id
	 */
	public List<Element> findByVariablesId(String variablesId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Element e, IN (e.variables) c where e.clientId = :clientId and c.id = :variablesId",
						Element.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("variablesId", variablesId).getResultList();
	}
	/**
	 * Find by reference: formulas
	 */
	public List<Element> findByFormulas(ElementFormula formulas) {
		return this.findByFormulasId(formulas.getId());
	}
	/**
	 * Find by ID of reference: formulas.id
	 */
	public List<Element> findByFormulasId(String formulasId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Element e, IN (e.formulas) c where e.clientId = :clientId and c.id = :formulasId",
						Element.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("formulasId", formulasId).getResultList();
	}
}
