/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.elem;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementInput;

/**
 * Interface to expose business functions specific for {@link ElementInput} domain
 * entity.
 */
public interface IElementInputService extends IEntityService<ElementInput> {

	/**
	 * Find by reference: element
	 */
	public List<ElementInput> findByElement(Element element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementInput> findByElementId(String elementId);

	/**
	 * Find by reference: crossReference
	 */
	public List<ElementInput> findByCrossReference(Element crossReference);

	/**
	 * Find by ID of reference: crossReference.id
	 */
	public List<ElementInput> findByCrossReferenceId(String crossReferenceId);
}
