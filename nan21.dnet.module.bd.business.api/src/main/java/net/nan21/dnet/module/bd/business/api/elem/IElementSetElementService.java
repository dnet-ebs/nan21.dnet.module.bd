/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.elem;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSet;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSetElement;

/**
 * Interface to expose business functions specific for {@link ElementSetElement} domain
 * entity.
 */
public interface IElementSetElementService
		extends
			IEntityService<ElementSetElement> {

	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(ElementSet elementSet,
			Element element);

	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(Long elementSetId, Long elementId);

	/**
	 * Find by reference: elementSet
	 */
	public List<ElementSetElement> findByElementSet(ElementSet elementSet);

	/**
	 * Find by ID of reference: elementSet.id
	 */
	public List<ElementSetElement> findByElementSetId(String elementSetId);

	/**
	 * Find by reference: element
	 */
	public List<ElementSetElement> findByElement(Element element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementSetElement> findByElementId(String elementId);
}
