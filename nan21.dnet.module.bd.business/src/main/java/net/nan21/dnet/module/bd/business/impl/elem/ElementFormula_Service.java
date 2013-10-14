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
import net.nan21.dnet.module.bd.business.api.elem.IElementFormulaService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementFormula;

/**
 * Repository functionality for {@link ElementFormula} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementFormula_Service
		extends
			AbstractEntityService<ElementFormula>
		implements
			IElementFormulaService {

	public ElementFormula_Service() {
		super();
	}

	public ElementFormula_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementFormula> getEntityClass() {
		return ElementFormula.class;
	}
	/**
	 * Find by reference: element
	 */
	public List<ElementFormula> findByElement(Element element) {
		return this.findByElementId(element.getId());
	}
	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementFormula> findByElementId(String elementId) {
		return (List<ElementFormula>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementFormula e where e.clientId = :clientId and e.element.id = :elementId",
						ElementFormula.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("elementId", elementId).getResultList();
	}
}
