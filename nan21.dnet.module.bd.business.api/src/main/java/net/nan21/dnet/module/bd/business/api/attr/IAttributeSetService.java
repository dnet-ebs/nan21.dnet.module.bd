/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;

/**
 * Interface to expose business functions specific for {@link AttributeSet} domain
 * entity.
 */
public interface IAttributeSetService extends IEntityService<AttributeSet> {

	/**
	 * Find by unique key
	 */
	public AttributeSet findByCode(String code);

	/**
	 * Find by unique key
	 */
	public AttributeSet findByName(String name);
}
