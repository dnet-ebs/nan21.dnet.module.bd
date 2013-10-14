/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.elem;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementFormula;

/**
 * Interface to expose business functions specific for {@link ElementFormula} domain
 * entity.
 */
public interface IElementFormulaService extends IEntityService<ElementFormula> {

	/**
	 * Find by reference: element
	 */
	public List<ElementFormula> findByElement(Element element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementFormula> findByElementId(String elementId);
}
