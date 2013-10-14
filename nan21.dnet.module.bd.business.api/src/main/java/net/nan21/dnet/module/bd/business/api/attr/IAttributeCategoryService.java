/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;

/**
 * Interface to expose business functions specific for {@link AttributeCategory} domain
 * entity.
 */
public interface IAttributeCategoryService
		extends
			IEntityService<AttributeCategory> {

	/**
	 * Find by unique key
	 */
	public AttributeCategory findByCode(String code);

	/**
	 * Find by unique key
	 */
	public AttributeCategory findByName(String name);
}
