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
import net.nan21.dnet.module.bd.business.api.elem.IElementSetElementService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSet;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSetElement;

/**
 * Repository functionality for {@link ElementSetElement} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementSetElement_Service
		extends
			AbstractEntityService<ElementSetElement>
		implements
			IElementSetElementService {

	public ElementSetElement_Service() {
		super();
	}

	public ElementSetElement_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementSetElement> getEntityClass() {
		return ElementSetElement.class;
	}
	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(ElementSet elementSet,
			Element element) {
		return (ElementSetElement) this
				.getEntityManager()
				.createNamedQuery(ElementSetElement.NQ_FIND_BY_SET_ELEM)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("elementSet", elementSet)
				.setParameter("element", element).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(Long elementSetId, Long elementId) {
		return (ElementSetElement) this
				.getEntityManager()
				.createNamedQuery(
						ElementSetElement.NQ_FIND_BY_SET_ELEM_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("elementSetId", elementSetId)
				.setParameter("elementId", elementId).getSingleResult();
	}
	/**
	 * Find by reference: elementSet
	 */
	public List<ElementSetElement> findByElementSet(ElementSet elementSet) {
		return this.findByElementSetId(elementSet.getId());
	}
	/**
	 * Find by ID of reference: elementSet.id
	 */
	public List<ElementSetElement> findByElementSetId(String elementSetId) {
		return (List<ElementSetElement>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementSetElement e where e.clientId = :clientId and e.elementSet.id = :elementSetId",
						ElementSetElement.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("elementSetId", elementSetId).getResultList();
	}
	/**
	 * Find by reference: element
	 */
	public List<ElementSetElement> findByElement(Element element) {
		return this.findByElementId(element.getId());
	}
	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementSetElement> findByElementId(String elementId) {
		return (List<ElementSetElement>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementSetElement e where e.clientId = :clientId and e.element.id = :elementId",
						ElementSetElement.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("elementId", elementId).getResultList();
	}
}
