/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.elem;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSet;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Interface to expose business functions specific for {@link ElementSet} domain
 * entity.
 */
public interface IElementSetService extends IEntityService<ElementSet> {

	/**
	 * Find by unique key
	 */
	public ElementSet findByEngine_name(Engine engine, String name);

	/**
	 * Find by unique key
	 */
	public ElementSet findByEngine_name(Long engineId, String name);

	/**
	 * Find by reference: engine
	 */
	public List<ElementSet> findByEngine(Engine engine);

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementSet> findByEngineId(String engineId);
}
