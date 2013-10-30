/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.LookupItem;

/**
 * Interface to expose business functions specific for {@link LookupItem} domain
 * entity.
 */
public interface ILookupItemService extends IEntityService<LookupItem> {

	/**
	 * Find by unique key
	 */
	public LookupItem findByCode(String type, String code);

	/**
	 * Find by unique key
	 */
	public LookupItem findByName(String type, String name);
}
