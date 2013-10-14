/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.elem;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementCategory;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementType;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Interface to expose business functions specific for {@link ElementType} domain
 * entity.
 */
public interface IElementTypeService extends IEntityService<ElementType> {

	/**
	 * Find by unique key
	 */
	public ElementType findByEngine_name(Engine engine, String name);

	/**
	 * Find by unique key
	 */
	public ElementType findByEngine_name(Long engineId, String name);

	/**
	 * Find by reference: engine
	 */
	public List<ElementType> findByEngine(Engine engine);

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementType> findByEngineId(String engineId);

	/**
	 * Find by reference: category
	 */
	public List<ElementType> findByCategory(ElementCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ElementType> findByCategoryId(String categoryId);
}
