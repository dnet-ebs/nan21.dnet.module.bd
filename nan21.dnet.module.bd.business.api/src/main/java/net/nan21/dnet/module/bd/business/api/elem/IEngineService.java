/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.elem;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;

/**
 * Interface to expose business functions specific for {@link Engine} domain
 * entity.
 */
public interface IEngineService extends IEntityService<Engine> {

	/**
	 * Find by unique key
	 */
	public Engine findByName(String name);
}
