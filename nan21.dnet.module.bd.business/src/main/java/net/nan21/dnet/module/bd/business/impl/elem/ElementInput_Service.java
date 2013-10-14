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
import net.nan21.dnet.module.bd.business.api.elem.IElementInputService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementInput;

/**
 * Repository functionality for {@link ElementInput} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementInput_Service extends AbstractEntityService<ElementInput>
		implements
			IElementInputService {

	public ElementInput_Service() {
		super();
	}

	public ElementInput_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementInput> getEntityClass() {
		return ElementInput.class;
	}
	/**
	 * Find by reference: element
	 */
	public List<ElementInput> findByElement(Element element) {
		return this.findByElementId(element.getId());
	}
	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementInput> findByElementId(String elementId) {
		return (List<ElementInput>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementInput e where e.clientId = :clientId and e.element.id = :elementId",
						ElementInput.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("elementId", elementId).getResultList();
	}
	/**
	 * Find by reference: crossReference
	 */
	public List<ElementInput> findByCrossReference(Element crossReference) {
		return this.findByCrossReferenceId(crossReference.getId());
	}
	/**
	 * Find by ID of reference: crossReference.id
	 */
	public List<ElementInput> findByCrossReferenceId(String crossReferenceId) {
		return (List<ElementInput>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementInput e where e.clientId = :clientId and e.crossReference.id = :crossReferenceId",
						ElementInput.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("crossReferenceId", crossReferenceId)
				.getResultList();
	}
}
